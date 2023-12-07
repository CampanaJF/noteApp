#!/bin/bash

if ! docker info &>/dev/null; then
  echo "Docker is not running. Please start Docker and try again."
  exit 1
fi

cd ./backend
docker-compose up -d 
sleep 40


./gradlew bootRun &
cd ..

cd ./frontend
npm i

ng serve 

