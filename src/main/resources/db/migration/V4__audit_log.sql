CREATE TABLE audit_log (
    id BIGSERIAL PRIMARY KEY,
    actor_id BIGINT REFERENCES "user"(id) ON DELETE SET NULL,
    action VARCHAR(40) NOT NULL,
    document_id BIGINT REFERENCES document(id) ON DELETE SET NULL,
    version_id BIGINT REFERENCES document_version(id) ON DELETE SET NULL,
    detail JSONB,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE INDEX ix_audit_log_document ON audit_log (document_id, version_id);
CREATE INDEX ix_audit_log_actor_created_at ON audit_log (actor_id, created_at);
