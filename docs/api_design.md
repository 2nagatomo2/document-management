# ドキュメント管理システム API 設計書

## 1. 認証・ユーザー管理 API

### 1.1 ユーザー登録

- **POST** `/api/auth/register`
- **Request (JSON)**

```json
{
  "username": "testuser",
  "email": "test@example.com",
  "password": "password123"
}
```

- **Response (201 Created)**

```json
{
  "id": 1,
  "username": "testuser",
  "email": "test@example.com"
}
```

---

### 1.2 ログイン

- **POST** `/api/auth/login`
- **Request**

```json
{
  "email": "test@example.com",
  "password": "password123"
}
```

- **Response (200 OK)**

```json
{
  "token": "jwt-token-example"
}
```

---

### 1.3 ユーザー情報取得

- **GET** `/api/users/me`
- **Header**: `Authorization: Bearer <JWT>`
- **Response**

```json
{
  "id": 1,
  "username": "testuser",
  "email": "test@example.com",
  "role": "USER"
}
```

---

## 2. ドキュメント管理 API

### 2.1 ドキュメントアップロード

- **POST** `/api/documents`
- **Header**: `Authorization: Bearer <JWT>`
- **Request**: `multipart/form-data`

  - `file`: ドキュメントファイル
  - `title`: ドキュメントタイトル
  - `tags`: カンマ区切りタグ (例: `"invoice,2025"`)

- **Response (201 Created)**

```json
{
  "id": 101,
  "title": "請求書2025年3月",
  "tags": ["invoice", "2025"],
  "uploadedBy": "testuser",
  "uploadDate": "2025-09-09T12:00:00",
  "version": 1,
  "fileUrl": "/documents/101/download"
}
```

---

### 2.2 ドキュメントダウンロード

- **GET** `/api/documents/{id}/download`
- **Header**: `Authorization: Bearer <JWT>`
- **Response**: ファイルバイナリ

---

### 2.3 ドキュメント一覧取得

- **GET** `/api/documents`
- **Query Parameters**

  - `title` (optional)
  - `tag` (optional)
  - `uploadedBy` (optional)

- **Response (200 OK)**

```json
[
  {
    "id": 101,
    "title": "請求書2025年3月",
    "tags": ["invoice", "2025"],
    "uploadedBy": "testuser",
    "uploadDate": "2025-09-09T12:00:00",
    "version": 1
  },
  {
    "id": 102,
    "title": "契約書2025年",
    "tags": ["contract"],
    "uploadedBy": "admin",
    "uploadDate": "2025-09-08T09:30:00",
    "version": 2
  }
]
```

---

### 2.4 ドキュメント詳細取得

- **GET** `/api/documents/{id}`
- **Response**

```json
{
  "id": 101,
  "title": "請求書2025年3月",
  "tags": ["invoice", "2025"],
  "uploadedBy": "testuser",
  "uploadDate": "2025-09-09T12:00:00",
  "version": 1,
  "fileUrl": "/documents/101/download",
  "thumbnailUrl": "/documents/101/thumbnail"
}
```

---

### 2.5 ドキュメント削除

- **DELETE** `/api/documents/{id}`
- **Header**: `Authorization: Bearer <JWT>`
- **Response (204 No Content)**

---

## 3. 非同期処理 API (ElasticMQ 経由)

### 3.1 サムネイル生成ジョブ投入

- **Event**: ドキュメントアップロード後、バックエンドから ElasticMQ に送信

```json
{
  "eventType": "GENERATE_THUMBNAIL",
  "documentId": 101,
  "filePath": "minio://documents/101-v1.pdf"
}
```

### 3.2 テキスト抽出ジョブ投入

- **Event**

```json
{
  "eventType": "EXTRACT_TEXT",
  "documentId": 101,
  "filePath": "minio://documents/101-v1.pdf"
}
```

### 3.3 非同期処理結果反映

- ElasticMQ のメッセージを消費し、処理結果を DB に保存
- 例: サムネイルパス、抽出テキストを `documents` テーブルに更新

---

## 4. エラーレスポンス仕様

- **401 Unauthorized**

```json
{
  "error": "Unauthorized",
  "message": "Invalid or expired JWT"
}
```

- **403 Forbidden**

```json
{
  "error": "Forbidden",
  "message": "Access denied"
}
```

- **404 Not Found**

```json
{
  "error": "Not Found",
  "message": "Document not found"
}
```

- **500 Internal Server Error**

```json
{
  "error": "Internal Server Error",
  "message": "Unexpected error occurred"
}
```
