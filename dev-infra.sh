#!/bin/bash
# Starts the infrastructure only: postgres + keycloak

docker compose --env-file .env.development up --build postgres keycloak
