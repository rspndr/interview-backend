# RSPNDR Interview Project

This project uses Docker to run the application and its dependencies locally.

## Prerequisites
- Docker: Either Docker Desktop https://www.docker.com/products/docker-desktop/ or Colima https://formulae.brew.sh/formula/colima
- IntelliJ Community Edition: https://www.jetbrains.com/idea/download/
- Postman: https://www.postman.com/downloads/
- Java JDK 21: see below for instructions

## Install Azul Zulu OpenJDK 21
To install Azul Zulu OpenJDK 21, you can follow these steps:

1. Go to Gradle Settings
![Screenshot 2026-03-11 at 16.12.59.png](screenshots/Screenshot%202026-03-11%20at%2016.12.59.png)
2. At the bottom of Gradle Settings, click the dropdown menu for "Gradle JVM" and select "Add JDK..."
![Screenshot 2026-03-11 at 16.10.57.png](screenshots/Screenshot%202026-03-11%20at%2016.10.57.png)
3. Download JDK...
![Screenshot 2026-03-11 at 16.11.03.png](screenshots/Screenshot%202026-03-11%20at%2016.11.03.png)
4. Select version 21, Azul Zulu Community, and click "Download"
![Screenshot 2026-03-11 at 16.11.15.png](screenshots/Screenshot%202026-03-11%20at%2016.11.15.png)


## Getting Started

To start the development environment, ensure docker is running, then run:

```bash
./dev.sh
```

NOTE: Environment file `.env.development` is deliberately checked into git with unsecure dummy passwords.

This script will start all required services, including:
- PostgreSQL
- Keycloak
- The backend application

Once the services are running, the API will be available at:

http://localhost:8090

Keycloak administrator console will be available at:

http://keycloak:8080

To allow keycloak to be recognized in place of localhost in your browser, add the following entry to your hosts file:

run `sudo nano /etc/hosts` and add the following line:

```
...
127.0.0.1       localhost
127.0.0.1       keycloak   <--- THIS LINE
255.255.255.255 broadcasthost
...
```

## Accessing Postgres Data in Docker Exec

Database Name: `interview`

Username: `interview-admin`

Password: `interview-admin`

To access the Postgres database running in Docker, you can use the following command:

```bash
docker ps -> confirm the name or ID of postgres:16 container (e.g., interview-postgres-1)

docker exec -it interview-postgres-1 psql -U interview-admin -d interview
```

A few example commands while in PSQL to get you started: 

```
\l             -- list databases
\dt            -- list tables
\c interview   -- connect to interview database
\d assignment  -- describe assignment table

SELECT * FROM "user";  -- query all users (quotes are required because "user" is a reserved keyword in SQL)
SELECT * FROM assignment;  -- query all assignments
```

## Test User

A test user is preconfigured in Keycloak for convenience.

- Username: `testuser`
- Password: `password`
- Roles: `ROLE_USER`

You can use these credentials to authenticate when testing secured endpoints.
