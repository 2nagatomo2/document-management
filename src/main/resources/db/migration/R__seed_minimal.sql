-- R__seed_minimal.sql
-- Repeatable migration for seed data

-- Insert admin user (password is "admin123" hashed with BCrypt)
INSERT INTO "user"(username, email, password_hash, role)
VALUES ('admin', 'admin@example.com', '$2a$10$eImiTXuWVxfM37uY4JANjOEdxtHN4nwz0W2K/GxdxKqHQZflpg8wG', 'ADMIN')
ON CONFLICT (email) DO NOTHING;

-- Insert basic tags
INSERT INTO tag(name) VALUES ('invoice'), ('contract'), ('2025'), ('draft'), ('final')
ON CONFLICT (name) DO NOTHING;