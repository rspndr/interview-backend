#!/bin/bash
# Builds and starts the java backend only (expects infra to already be running via dev-infra.sh)

./gradlew assemble

docker compose --env-file .env.development up --build --no-deps backend
