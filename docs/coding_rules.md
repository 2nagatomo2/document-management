# コーディング規約

## 1. 概要

本ドキュメントは、ドキュメント管理システムの開発における統一されたコーディング規約を定めるものです。
全ての開発者はこの規約に従ってコードを記述することで、保守性と可読性を高めます。

---

## 2. 一般原則

### 2.1 コードの可読性

- 変数名、メソッド名、クラス名は意味を明確に表現する
- 適切なコメントを付与する（特に複雑なロジックや業務ルール）
- ネストを深くしすぎない（最大3レベル程度）

### 2.2 SOLID原則の遵守

- **S**: Single Responsibility Principle（単一責任の原則）
- **O**: Open/Closed Principle（開放閉鎖の原則）
- **L**: Liskov Substitution Principle（リスコフの置換原則）
- **I**: Interface Segregation Principle（インターフェイス分離の原則）
- **D**: Dependency Inversion Principle（依存性逆転の原則）

---

## 3. Java コーディング規約

### 3.1 命名規則

#### クラス名
- PascalCase を使用
- 名詞または名詞句
- 例: `UserService`, `DocumentRepository`, `AuthenticationFilter`

#### メソッド名
- camelCase を使用
- 動詞または動詞句
- 例: `findByEmail()`, `registerUser()`, `calculateTotalSize()`

#### 変数名
- camelCase を使用
- 意味のある名前を付ける
- 例: `userId`, `documentList`, `maxRetryCount`

#### 定数
- UPPER_SNAKE_CASE を使用
- 例: `MAX_FILE_SIZE`, `DEFAULT_TIMEOUT`, `API_VERSION`

### 3.2 パッケージ構成

```
com.example.docmanager
├── config          # 設定クラス
├── controller      # REST API エンドポイント
├── service         # ビジネスロジック
├── dao             # データアクセス層（Doma2）
├── entity          # エンティティクラス
├── dto             # データ転送オブジェクト
├── exception       # カスタム例外
└── util            # ユーティリティクラス
```

### 3.3 クラス設計

#### Record の活用
- DTOには Java Record を使用
- イミュータブルなデータ構造を推奨

```java
public record UserResponse(
    Long id,
    String username,
    String email,
    String role
) {}
```

#### Lombok の使用
- エンティティクラスには適宜 Lombok を使用可能
- ただし、`@Data` の乱用は避ける

### 3.4 エラーハンドリング

- カスタム例外クラスを作成し、適切に使い分ける
- ログ出力を適切に行う（SLF4J + Logback）
- ユーザーに返すエラーメッセージと内部ログは分離する

```java
try {
    // 処理
} catch (CustomException e) {
    logger.error("Error occurred: {}", e.getMessage(), e);
    throw new ApiException("ユーザー向けエラーメッセージ");
}
```

### 3.5 依存性注入

- コンストラクタインジェクションを優先
- `@Autowired` のフィールドインジェクションは避ける

```java
// 推奨
@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
}

// 非推奨
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
}
```

---

## 4. テストコード規約

本プロジェクトでは、**JUnit 5** と **Spock Framework** の両方を使用します。
勉強目的のため、同じような機能に対して JUnit と Spock 両方のテストが存在しても構いません。

### 4.1 JUnit 5 テスト

#### 命名規則
- テストクラス名: `{対象クラス名}Test`
- テストメソッド名: `should{期待する動作}_when{条件}`

```java
@Test
void shouldReturnUser_whenEmailExists() {
    // given
    String email = "test@example.com";

    // when
    UserResponse user = userService.findByEmail(email);

    // then
    assertThat(user).isNotNull();
    assertThat(user.email()).isEqualTo(email);
}
```

#### テスト構造
- **Given-When-Then** パターンを使用
- AssertJ を活用した可読性の高いアサーション

### 4.2 Spock Framework テスト

#### 命名規則
- テストクラス名: `{対象クラス名}Spec`
- ファイル拡張子: `.groovy`
- 配置: `src/test/groovy` 以下

#### テスト構造
- Spock の BDD スタイルを活用
- `given-when-then` ブロックまたは `expect` ブロックを使用

```groovy
class UserServiceSpec extends Specification {

    def "should return user when email exists"() {
        given: "a valid email address"
        def email = "test@example.com"

        when: "finding user by email"
        def user = userService.findByEmail(email)

        then: "user should be returned"
        user != null
        user.email() == email
    }

    @Unroll
    def "should validate email format: #email is #valid"() {
        expect:
        emailValidator.isValid(email) == valid

        where:
        email               | valid
        "test@example.com"  | true
        "invalid-email"     | false
        "test@"             | false
    }
}
```

#### Spock の特徴的な機能

##### モックの活用
```groovy
def userDao = Mock(UserDao)
def userService = new UserService(userDao: userDao)

when:
userService.registerUser(request)

then:
1 * userDao.insert(_)
0 * userDao.delete(_)
```

##### データ駆動テスト
- `@Unroll` を使った複数パターンのテスト
- `where` ブロックでテストデータを定義

##### Spring Boot 統合テスト
```groovy
@SpringBootTest
@ActiveProfiles("test")
class AuthControllerIntegrationSpec extends Specification {

    @Autowired
    private AuthService authService

    def "should register and authenticate user"() {
        // テストコード
    }
}
```

### 4.3 テストの方針

#### JUnit vs Spock の使い分け（推奨）

**JUnit 5 を使う場合:**
- シンプルな単体テスト
- Java のみで完結するテスト
- チーム全体が Java に慣れている場合

**Spock を使う場合:**
- データ駆動テスト（複数パターンのテストケース）
- モックを多用する複雑なテスト
- BDD スタイルでテストの意図を明確にしたい場合
- Groovy の柔軟な構文を活用したい場合

#### 両方のテストが共存する場合
- 同じ機能に対して JUnit と Spock 両方のテストが存在しても良い（勉強目的）
- ただし、本番プロジェクトでは重複を避け、チームで統一する

### 4.4 テストのベストプラクティス

- テストは独立して実行可能にする
- テストデータはテストメソッド内で準備する
- テスト用の設定は `application-test.yml` で管理
- 統合テストは `@SpringBootTest` を使用
- モックは適切に使用し、過度なモック化は避ける

---

## 5. データベース（Doma2）規約

### 5.1 SQL ファイルの配置

- `src/main/resources/META-INF/{パッケージ名}/{Daoインターフェイス名}/{メソッド名}.sql`

### 5.2 命名規則

#### Dao インターフェイス
- `{エンティティ名}Dao` の形式
- 例: `UserDao`, `DocumentDao`

#### SQL ファイル名
- メソッド名と一致させる
- 例: `findByEmail.sql`, `insertUser.sql`

### 5.3 エンティティ設計

- テーブルと1対1でマッピング
- イミュータブルを推奨（`@Entity(immutable = true)`）
- 必要に応じて `@GeneratedValue` を使用

---

## 6. API 設計規約

### 6.1 REST API エンドポイント

- リソース指向の URL 設計
- HTTP メソッドを適切に使用（GET, POST, PUT, DELETE）

```
GET    /api/users          # ユーザー一覧取得
GET    /api/users/{id}     # ユーザー詳細取得
POST   /api/users          # ユーザー作成
PUT    /api/users/{id}     # ユーザー更新
DELETE /api/users/{id}     # ユーザー削除
```

### 6.2 レスポンス形式

- 成功時: JSON 形式でデータを返す
- エラー時: 統一されたエラーレスポンス形式を使用

```json
{
  "error": "Bad Request",
  "message": "Invalid input parameters",
  "timestamp": "2024-01-15T10:30:00Z"
}
```

### 6.3 ステータスコード

- `200 OK`: 成功
- `201 Created`: リソース作成成功
- `400 Bad Request`: リクエストエラー
- `401 Unauthorized`: 認証エラー
- `403 Forbidden`: 権限エラー
- `404 Not Found`: リソースが見つからない
- `500 Internal Server Error`: サーバーエラー

---

## 7. セキュリティ規約

### 7.1 認証・認可

- JWT トークンを使用した認証
- パスワードは必ずハッシュ化して保存（BCrypt）
- 機密情報は環境変数または設定ファイルで管理

### 7.2 入力バリデーション

- `@Valid` アノテーションを使用
- Bean Validation（Jakarta Validation）を活用

```java
public record UserRegistrationRequest(
    @NotBlank String username,
    @Email String email,
    @Size(min = 8) String password
) {}
```

---

## 8. ログ規約

### 8.1 ログレベル

- `ERROR`: エラー発生時
- `WARN`: 警告レベルの事象
- `INFO`: 重要な情報（ユーザー登録、認証成功など）
- `DEBUG`: デバッグ情報（開発時のみ）

### 8.2 ログ出力の指針

- 機密情報（パスワード、トークンなど）はログに出力しない
- ユーザー操作の重要なアクションは INFO レベルで記録
- 例外はスタックトレースを含めて出力

```java
logger.info("User registered successfully with email: {}", email);
logger.error("Failed to register user: {}", email, exception);
```

---

## 9. ドキュメント規約

### 9.1 Javadoc

- public なクラス、メソッドには Javadoc を記述
- パラメータ、戻り値、例外を明記

```java
/**
 * ユーザーをメールアドレスで検索します。
 *
 * @param email 検索するメールアドレス
 * @return ユーザー情報（存在しない場合は空の Optional）
 * @throws IllegalArgumentException email が null の場合
 */
public Optional<User> findByEmail(String email) {
    // 実装
}
```

### 9.2 Groovydoc（Spock テスト）

- Spock テストクラスにもドキュメントコメントを記述
- テストの意図や前提条件を明記

```groovy
/**
 * UserServiceの振る舞いをテストするSpecification
 *
 * このテストでは以下を検証します:
 * - ユーザー登録の成功ケース
 * - メール重複時のエラーハンドリング
 * - 認証処理の正常系・異常系
 */
class UserServiceSpec extends Specification {
    // テストコード
}
```

---

## 10. Git コミットメッセージ規約

### 10.1 フォーマット

```
<type>: <subject>

<body>

<footer>
```

### 10.2 Type

- `feat`: 新機能
- `fix`: バグ修正
- `docs`: ドキュメントのみの変更
- `style`: コードの意味に影響しない変更（フォーマットなど）
- `refactor`: リファクタリング
- `test`: テストの追加・修正
- `chore`: ビルドプロセスやツールの変更

### 10.3 例

```
feat: ユーザー登録機能を追加

- UserService に registerUser メソッドを実装
- パスワードのハッシュ化処理を追加
- バリデーションロジックを実装

Closes #123
```

---

## 11. まとめ

本コーディング規約は、チーム全体でのコード品質を保つための指針です。
特に本プロジェクトでは **JUnit** と **Spock** の両方を学習目的で使用するため、
それぞれの特性を理解し、適切に使い分けることを推奨します。

規約は必要に応じて更新され、全ての開発者が遵守することでプロジェクトの成功に貢献します。

---
