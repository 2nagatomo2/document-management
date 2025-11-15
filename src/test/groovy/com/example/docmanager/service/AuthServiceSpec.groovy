package com.example.docmanager.service

import com.example.docmanager.config.JwtUtil
import com.example.docmanager.dao.UserDao
import com.example.docmanager.dto.LoginRequest
import com.example.docmanager.dto.UserRegistrationRequest
import com.example.docmanager.entity.User
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification
import spock.lang.Subject

/**
 * AuthServiceのSpockテスト例
 *
 * Spockを使ったSpring Bootサービスクラスのユニットテスト
 */
class AuthServiceSpec extends Specification {

    // モック対象の依存関係
    def userDao = Mock(UserDao)
    def passwordEncoder = Mock(PasswordEncoder)
    def jwtUtil = Mock(JwtUtil)
    def authenticationManager = Mock(AuthenticationManager)

    // テスト対象のサービス
    @Subject
    def authService = new AuthService(
            userDao: userDao,
            passwordEncoder: passwordEncoder,
            jwtUtil: jwtUtil,
            authenticationManager: authenticationManager
    )

    def "registerUser should successfully create a new user"() {
        given: "a valid registration request"
        def request = new UserRegistrationRequest(
                "testuser",
                "test@example.com",
                "password123"
        )

        and: "no existing users with same email or username"
        userDao.findByEmail(request.email()) >> Optional.empty()
        userDao.findByUsername(request.username()) >> Optional.empty()

        and: "password encoder returns encoded password"
        passwordEncoder.encode(request.password()) >> "encodedPassword"

        and: "user dao insert succeeds"
        def expectedUser = new User(
                request.username(),
                request.email(),
                "encodedPassword",
                "USER"
        )
        expectedUser.setId(1L)
        userDao.insert(_) >> { User user ->
            user.setId(1L)
        }

        when: "registering the user"
        def result = authService.registerUser(request)

        then: "user should be created successfully"
        result != null
        result.username() == "testuser"
        result.email() == "test@example.com"
        result.role() == "USER"

        and: "userDao.insert should be called once"
        1 * userDao.insert(_)
    }

    def "registerUser should throw exception when email already exists"() {
        given: "a registration request with existing email"
        def request = new UserRegistrationRequest(
                "testuser",
                "existing@example.com",
                "password123"
        )

        and: "email already exists in database"
        def existingUser = new User("existing", "existing@example.com", "pass", "USER")
        userDao.findByEmail(request.email()) >> Optional.of(existingUser)

        when: "trying to register the user"
        authService.registerUser(request)

        then: "should throw RuntimeException"
        def exception = thrown(RuntimeException)
        exception.message.contains("Email is already in use")

        and: "insert should not be called"
        0 * userDao.insert(_)
    }

    def "registerUser should throw exception when username already exists"() {
        given: "a registration request with existing username"
        def request = new UserRegistrationRequest(
                "existinguser",
                "new@example.com",
                "password123"
        )

        and: "username already exists in database"
        def existingUser = new User("existinguser", "other@example.com", "pass", "USER")
        userDao.findByEmail(request.email()) >> Optional.empty()
        userDao.findByUsername(request.username()) >> Optional.of(existingUser)

        when: "trying to register the user"
        authService.registerUser(request)

        then: "should throw RuntimeException"
        def exception = thrown(RuntimeException)
        exception.message.contains("Username is already taken")

        and: "insert should not be called"
        0 * userDao.insert(_)
    }

    def "authenticateUser should return JWT token on successful authentication"() {
        given: "a valid login request"
        def loginRequest = new LoginRequest("test@example.com", "password123")

        and: "authentication manager returns successful authentication"
        def mockAuthentication = Mock(Authentication)
        authenticationManager.authenticate(_) >> mockAuthentication

        and: "jwt util generates a token"
        jwtUtil.generateJwtToken(loginRequest.email()) >> "mock.jwt.token"

        when: "authenticating the user"
        def result = authService.authenticateUser(loginRequest)

        then: "should return JWT response"
        result != null
        result.token() == "mock.jwt.token"

        and: "authentication manager should be called with correct credentials"
        1 * authenticationManager.authenticate { UsernamePasswordAuthenticationToken auth ->
            auth.principal == "test@example.com" &&
            auth.credentials == "password123"
        }
    }

    def "getCurrentUser should return user info when user exists"() {
        given: "an existing user email"
        def email = "test@example.com"
        def user = new User("testuser", email, "password", "USER")
        user.setId(1L)

        and: "user exists in database"
        userDao.findByEmail(email) >> Optional.of(user)

        when: "getting current user info"
        def result = authService.getCurrentUser(email)

        then: "should return user response"
        result != null
        result.id() == 1L
        result.username() == "testuser"
        result.email() == email
        result.role() == "USER"
    }

    def "getCurrentUser should throw exception when user not found"() {
        given: "a non-existing user email"
        def email = "nonexistent@example.com"

        and: "user does not exist in database"
        userDao.findByEmail(email) >> Optional.empty()

        when: "trying to get current user info"
        authService.getCurrentUser(email)

        then: "should throw RuntimeException"
        def exception = thrown(RuntimeException)
        exception.message == "User not found"
    }
}
