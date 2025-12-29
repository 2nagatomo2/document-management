-- document テーブルのインデックス
CREATE INDEX IF NOT EXISTS ix_document_title ON document USING btree (title);
CREATE INDEX IF NOT EXISTS ix_document_owned_by ON document USING btree (owned_by);
CREATE INDEX IF NOT EXISTS ix_document_is_public ON document USING btree (is_public);
CREATE INDEX IF NOT EXISTS ix_document_created_at ON document USING btree (created_at);
CREATE INDEX IF NOT EXISTS ix_document_updated_at ON document USING btree (updated_at);

-- document_version テーブルのインデックス
CREATE INDEX IF NOT EXISTS ix_document_version_document_id ON document_version USING btree (document_id);
CREATE INDEX IF NOT EXISTS ix_document_version_uploaded_at ON document_version USING btree (uploaded_at);

-- document_tag テーブルのインデックス
CREATE INDEX IF NOT EXISTS ix_document_tag_tag_id ON document_tag USING btree (tag_id);

-- user テーブルのインデックス
CREATE INDEX IF NOT EXISTS ix_user_created_at ON "user" USING btree (created_at);
