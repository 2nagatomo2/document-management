SELECT
    id,
    username,
    email,
    password_hash,
    role,
    created_at,
    updated_at
FROM
    "user"
WHERE
    email = /* email */'test@example.com'
