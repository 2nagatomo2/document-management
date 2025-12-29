# Coding Rules

このプロジェクトでは、Spring Boot + Doma を利用した Web アプリケーションを開発します。  
Claude でコード生成を行う際は、以下のルールに従ってください。

---

## 1. 命名規則

### パッケージ

- `com.example.docmanager` をルートパッケージとする
- サブパッケージは以下のように分ける
  - `entity` : Doma の `@Entity` を定義
  - `dao` : Doma の `@Dao` インターフェース
  - `service` : ビジネスロジック層
  - `controller` : REST API コントローラ
  - `config` : 設定クラス

### クラス名

- Entity: **単数形 + PascalCase**
  - 例: `User`, `Document`, `AuditLog`
- Dao: **Entity 名 + Dao**
  - 例: `UserDao`, `DocumentDao`
- Service: **Entity 名 + Service**
  - 例: `UserService`, `DocumentService`
- Controller: **Entity 名 + Controller**
  - 例: `AuthController`, `DocumentController`

### メソッド名

- Dao インターフェース
  - `findById`, `findAll`, `insert`, `update`, `delete` などシンプルに
- Service 層
  - ビジネスロジックを表す動詞 + 対象
  - 例: `uploadDocument`, `deleteDocument`, `generateThumbnail`

---

## 2. コーディングスタイル

### 共通ルール

- Java 17 を使用
- Spring Boot 公式のコーディングスタイルに準拠
- ログ出力には `Slf4j` を使用
- DTO は `record` で定義してもよい

### Entity

- Doma の `@Entity` を利用
- 主キーには `@Id` + `@GeneratedValue` を指定
- フィールド名は **スネークケースをキャメルケースに変換**する
  - DB: `user_id` → Java: `userId`

### Dao

- `@Dao` + `@ConfigAutowireable` を利用
- SQL は `resources/META-INF/...` に配置し、**SQL ファイルを必ず利用する**
- 自動生成される SQL は使わない（学習目的のため手書き SQL を徹底）

### Service

- `@Service` アノテーションを付与
- Dao を呼び出してビジネスロジックを記述
- トランザクション管理が必要な場合は `@Transactional` を利用

### Controller

- `@RestController` を利用
- API エンドポイントは **`/api/...`** に統一
- リクエスト/レスポンスは DTO を用意し、Entity を直接返さない

---

## 3. ディレクトリ構成

```bash

src/main/java/com/example/docmanager/
├── entity/ # Doma Entity
├── dao/ # Doma Dao
├── service/ # ビジネスロジック
├── controller/ # REST API
├── config/ # 設定クラス
└── DocManagerApplication.java

```

```bash

src/main/resources/
├── db/migration/ # Flyway マイグレーションファイル
├── META-INF/com/example/docmanager/dao/ # Doma SQL
└── application.yml

```

---

## 4. テスト

- テストフレームワーク: JUnit 5 + Spring Boot Test
- Dao 層のテストでは **テスト用 DB** を利用する
- Service 層では Dao をモック化することも可能

---

## 5. AI への指示

- Claude がコードを生成するときは、この `coding_rules.md` に従うこと
- 自動生成コードを最小限にし、**SQL は必ず `resources/META-INF/...` に手書きする**
- API 設計書 (`docs/api_design.md`) と DB 設計書 (`docs/db_design.md`) に準拠すること
