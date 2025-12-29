CREATE TABLE document_text (
    document_id BIGINT PRIMARY KEY REFERENCES document(id) ON DELETE CASCADE,
    version_id BIGINT NOT NULL,
    raw_text TEXT,
    text_tsv TSVECTOR GENERATED ALWAYS AS (to_tsvector('simple', coalesce(raw_text,''))) STORED,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

ALTER TABLE document_text
    ADD CONSTRAINT fk_document_text_version
    FOREIGN KEY (version_id) REFERENCES document_version(id) ON DELETE CASCADE;

-- 全文検索用のGINインデックスを作成
CREATE INDEX ix_document_text_tsv ON document_text USING GIN (text_tsv);