INSERT INTO "user" (
    username,
    email,
    password_hash,
    role,
    created_at,
    updated_at
) VALUES (
    /* user.username */'testuser',
    /* user.email */'test@example.com',
    /* user.passwordHash */'hashedpassword',
    /* user.role */'USER',
    NOW(),
    NOW()
)