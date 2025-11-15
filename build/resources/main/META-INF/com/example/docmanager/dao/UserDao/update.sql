UPDATE "user" SET
    username = /* user.username */'testuser',
    email = /* user.email */'test@example.com',
    password_hash = /* user.passwordHash */'hashedpassword',
    role = /* user.role */'USER',
    updated_at = NOW()
WHERE id = /* user.id */1