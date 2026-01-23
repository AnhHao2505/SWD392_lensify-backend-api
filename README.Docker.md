### Note

We are using port 8080 and 3306 for server and database, in Docker, 
respectively, so if you are running the `Docker container`
, it would conflict if you are using same port at your local machine.

`Application-docker.yml` is a profile configured for docker database,
which will connect us to the mysql container. Instead of the localhost container

### Building and running your application

When you're ready, start your application by running:
`docker compose up --build`.

Your application will be available at http://localhost:8080.

You may need to `docker compose down -v` then `docker compose up --build`
if you want to re-update the container after modifying the source code

### Might-be error

1. You might encounter error `Access Denied root@localhost`.
Then watch to reset your `root password` at https://youtu.be/uD2c1GQSc-I?si=v0UiEQ9zWb1whqV9

2. You might encounter this situation `Forgot to running container on Docker Desktop`.
If you forgot, then just turn on the Mysql service and run server locally. If you do not, then just run Docker 
and you wouldn't need to turn on locally. Docker will handle your environment.