package com.example.docmanager.integration

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

/**
 * Spring Boot統合テストのサンプル
 *
 * Spockを使ったSpring Boot統合テストの例
 * @SpringBootTestアノテーションを使用してSpringコンテキストをロードする
 */
@SpringBootTest
@ActiveProfiles("test")
class SampleIntegrationSpec extends Specification {

    def "Spring context should load successfully"() {
        expect: "context loads without errors"
        true
    }

    // 統合テストの例
    // 実際のテストでは、@Autowiredを使ってBeanを注入し、
    // エンドツーエンドのテストを行います
    //
    // 例:
    // @Autowired
    // private AuthService authService
    //
    // def "should register and authenticate user"() {
    //     given: "a registration request"
    //     def request = new UserRegistrationRequest(...)
    //
    //     when: "registering the user"
    //     def userResponse = authService.registerUser(request)
    //
    //     then: "user should be created"
    //     userResponse != null
    //     ...
    // }
}
