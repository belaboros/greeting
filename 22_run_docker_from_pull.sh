#!/bin/sh

DOCKER_IMAGE=belaboros/greeting

docker pull ${DOCKER_IMAGE}
docker run -p 9090:9090 ${DOCKER_IMAGE}




