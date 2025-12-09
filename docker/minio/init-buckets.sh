#!/bin/bash

set -e

sleep 1

mc alias set myminio http://minio:9000 minioadmin minioadmin
mc mb myminio/documents --ignore-existing

echo "Bucket created successfully"