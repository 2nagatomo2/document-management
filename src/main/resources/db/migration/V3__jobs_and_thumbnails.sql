CREATE TABLE job (
    id BIGSERIAL PRIMARY KEY,
    type VARCHAR(40) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    document_id BIGINT REFERENCES document(id) ON DELETE SET NULL,
    version_id BIGINT REFERENCES document_version(id) ON DELETE SET NULL,
    payload JSONB,
    sqs_message_id VARCHAR(128),
    attempts INT NOT NULL DEFAULT 0,
    next_run_at TIMESTAMPTZ,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX ix_job_status_type ON job (status, type);
CREATE INDEX ix_job_next_run_at ON job (next_run_at);
CREATE INDEX ix_job_document_version ON job (document_id, version_id);

CREATE TABLE thumbnail (
    id BIGSERIAL PRIMARY KEY,
    version_id BIGINT NOT NULL REFERENCES document_version(id) ON DELETE CASCADE,
    kind VARCHAR(20) NOT NULL,
    object_key VARCHAR(512) NOT NULL,
    width INT,
    height INT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    UNIQUE (version_id, kind)
);
