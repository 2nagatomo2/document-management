# Docker環境セットアップ

このディレクトリには、ドキュメント管理システムの開発環境用Docker設定が含まれています。

## 含まれるサービス

### PostgreSQL (Port: 5432)
- Database: `docmanager`
- Username: `docmanager`
- Password: `password`

### MinIO (Ports: 9000, 9001)
- S3互換オブジェクトストレージ
- Console: http://localhost:9001
- API: http://localhost:9000
- Access Key: `minioadmin`
- Secret Key: `minioadmin`

### ElasticMQ (Ports: 9324, 9325)
- SQS互換メッセージキュー
- API: http://localhost:9324
- Stats: http://localhost:9325

## 起動コマンド

```bash
# バックグラウンドで起動
docker-compose up -d

# ログを確認
docker-compose logs -f

# 停止
docker-compose down

# データも削除して停止
docker-compose down -v
```

## 接続確認

### PostgreSQL
```bash
psql -h localhost -p 5432 -U docmanager -d docmanager
```

### MinIO
ブラウザで http://localhost:9001 にアクセス

### ElasticMQ
```bash
curl http://localhost:9324/
```