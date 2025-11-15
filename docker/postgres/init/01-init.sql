-- Initialize database for document management system
-- This script runs when the PostgreSQL container starts for the first time

-- Create database if not exists (already created by POSTGRES_DB env var)
-- Just ensure proper encoding and locale
ALTER DATABASE docmanager SET timezone TO 'UTC';

-- Grant necessary permissions to the user
GRANT ALL PRIVILEGES ON DATABASE docmanager TO docmanager;