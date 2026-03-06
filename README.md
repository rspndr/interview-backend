# RSPNDR Interview Project

This project uses Docker to run the application and its dependencies locally.

## Getting Started

To start the development environment, run:

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

## Test User

A test user is preconfigured in Keycloak for convenience.

- Username: `testuser`
- Password: `password`
- Roles: `ROLE_USER`

You can use these credentials to authenticate when testing secured endpoints.
