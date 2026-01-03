SELECT
    document_id,
    version_id,
    raw_text,
    updated_at
FROM
    document_text
WHERE
    document_id = /* documentId */0