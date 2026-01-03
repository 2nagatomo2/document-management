SELECT
    d.id,
    d.title,
    u.username as uploaded_by,
    dv.uploaded_at,
    dv.version
FROM document d
INNER JOIN document_version dv ON d.current_version_id = dv.id
INNER JOIN "user" u ON dv.uploaded_by = u.id
WHERE
    d.id = /* id */0
