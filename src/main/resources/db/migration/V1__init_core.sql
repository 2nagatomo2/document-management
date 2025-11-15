-- V1__init_core.sql
-- Create core tables: user, document, document_version, tag, document_tag

-- user table
CREATE TABLE "user" (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

-- document table
CREATE TABLE document (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    owned_by BIGINT NOT NULL REFERENCES "user"(id),
    current_version_id BIGINT,
    is_public BOOLEAN NOT NULL DEFAULT false,
    created_by BIGINT NOT NULL REFERENCES "user"(id),
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

-- document_version table
CREATE TABLE document_version (
    id BIGSERIAL PRIMARY KEY,
    document_id BIGINT NOT NULL REFERENCES document(id) ON DELETE CASCADE,
    version INT NOT NULL,
    object_key VARCHAR(512) NOT NULL,
    content_type VARCHAR(100) NOT NULL,
    size_bytes BIGINT NOT NULL DEFAULT 0,
    checksum_sha256 CHAR(64) NOT NULL,
    uploaded_by BIGINT NOT NULL REFERENCES "user"(id),
    uploaded_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    UNIQUE (document_id, version)
);

-- Add foreign key for current_version_id (circular reference handled after table creation)
ALTER TABLE document
    ADD CONSTRAINT fk_document_current_version
    FOREIGN KEY (current_version_id) REFERENCES document_version(id);

-- tag table
CREATE TABLE tag (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(64) NOT NULL UNIQUE
);

-- document_tag (many-to-many relationship)
CREATE TABLE document_tag (
    document_id BIGINT NOT NULL REFERENCES document(id) ON DELETE CASCADE,
    tag_id BIGINT NOT NULL REFERENCES tag(id) ON DELETE CASCADE,
    PRIMARY KEY (document_id, tag_id)
);

-- Indexes for performance
CREATE INDEX ix_user_username ON "user" USING BTREE (username);
CREATE INDEX ix_user_email ON "user" USING BTREE (email);

CREATE INDEX ix_document_title ON document USING BTREE (title);
CREATE INDEX ix_document_owned_by ON document USING BTREE (owned_by);
CREATE INDEX ix_document_is_public ON document USING BTREE (is_public);

CREATE INDEX ix_document_version_document_id ON document_version USING BTREE (document_id);
CREATE INDEX ix_document_version_uploaded_at ON document_version USING BTREE (uploaded_at);

CREATE INDEX ix_document_tag_tag_id ON document_tag USING BTREE (tag_id);