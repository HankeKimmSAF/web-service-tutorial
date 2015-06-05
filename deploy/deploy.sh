#!/bin/bash

rm -fr build
mkdir build
cp ../target/web-service-tutorial-1.0-SNAPSHOT.jar build

docker build -t web-service-tutorial .
