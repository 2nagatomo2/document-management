SELECT
    id,
    actor_id,
    action,
    document_id,
    version_id,
    detail,
    created_at
FROM
    audit_log
WHERE
    id = /* id */0
