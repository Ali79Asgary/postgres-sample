#!/bin/bash
MODE=$1
VER=$2

if [ "$VER" == "" ];
then
   VER="1.0"
fi

if [ "$MODE" == "DEV" ];
then
    docker build --no-cache -f Dockerfilelocal -t medrick/postgresql-dev:$VER .
    _IMG=medrick/postgresql-dev:$VER _PROFILE=dev docker stack deploy -c docker-compose.yml medrick-postgresql
else
    docker build --no-cache -t medrick/postgresql:$VER .
    _IMG=medrick/postgresql:$VER _PROFILE=prod docker stack deploy -c docker-compose.yml medrick-postgresql
fi