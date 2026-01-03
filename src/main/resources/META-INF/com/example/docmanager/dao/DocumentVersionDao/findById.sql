SELECT
    id,
    document_id,
    version,
    object_key,
    content_type,
    size_bytes,
    checksum_sha256,
    uploaded_by,
    uploaded_at
FROM
    document_version
WHERE
    id = /* id */0
