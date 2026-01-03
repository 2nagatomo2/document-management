SELECT
    document_id,
    version_id,
    raw_text,
    updated_at
FROM
    document_text
ORDER BY
    updated_at DESC;