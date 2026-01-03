SELECT
    id,
    version_id,
    kind,
    object_key,
    width,
    height,
    created_at
FROM
    thumbnail
ORDER BY
    created_at DESC
