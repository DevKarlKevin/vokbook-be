# VOKBOOK API

VOKBOOK API.

## Building

`gradlew clean build`

## Local development setup

* PostgreSQL

`docker volume create vok-postgresql-data`

`docker compose -f docker/postgresql.yml up -d`