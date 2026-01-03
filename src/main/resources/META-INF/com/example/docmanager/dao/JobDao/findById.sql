SELECT
    id,
    type,
    status,
    document_id,
    version_id,
    payload,
    sqs_message_id,
    attempts,
    next_run_at,
    created_at,
    updated_at
FROM
    job
WHERE
    id = /* id */0
