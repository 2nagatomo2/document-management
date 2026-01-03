SELECT
    id,
    title,
    description,
    owned_by,
    current_version_id,
    is_public,
    created_by,
    created_at,
    updated_at
FROM
    document
ORDER BY
    created_at DESC
