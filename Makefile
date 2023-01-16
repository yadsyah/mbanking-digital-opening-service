COMMIT_ID_HASH ?= $(shell git rev-parse HEAD)
VERSION_BRANCH ?= $(shell git symbolic-ref --short HEAD)
APP     ?= digital-opening-service
IMAGE   ?= $(APP):$(COMMIT_ID_HASH)
VERSION ?= $(VERSION_BRANCH)-$(COMMIT_ID_HASH)
MY_HUB_DOCKER ?= diyset
.DEFAULT_GOAL := list

.PHONY: list
clean:
	@echo "Clean All Container"
	- docker rm -f $(APP)
list:
	@echo "Make sure u set specific target dude !!"
	@LC_ALL=C $(MAKE) -pRrq -f $(lastword $(MAKEFILE_LIST)) : 2>/dev/null | awk -v RS= -F: '/^# File/,/^# Finished Make data base/ {if ($$1 !~ "^[#.]") {print $$1}}' | sort | egrep -v -e '^[^[:alnum:]]' -e '^$@$$'
maven-verify:
	- mvn clean verify -Dmaven.test.skip
run-spring-boot:
	- mvn spring-boot:run
compile:
	- mvn clean install -Dmaven.test.skip
docker-build:
	- docker build -f docker/Dockerfile -t $(MY_HUB_DOCKER)/$(APP):$(VERSION_BRANCH)-latest .
docker-build-without-compile:
	- make compile
	- docker build -f docker/without-build.Dockerfile -t $(MY_HUB_DOCKER)/$(APP):$(VERSION_BRANCH)-latest .
docker-push:
	- make docker-build-without-compile
	- docker tag $(MY_HUB_DOCKER)/$(APP):$(VERSION_BRANCH)-latest $(MY_HUB_DOCKER)/$(APP):$(VERSION_BRANCH)-latest
	- docker push $(MY_HUB_DOCKER)/$(APP):$(VERSION_BRANCH)-latest
docker-push-latest:
	- make docker-build
	- docker tag $(MY_HUB_DOCKER)/$(APP):$(VERSION_BRANCH)-latest $(MY_HUB_DOCKER)/$(APP):$(VERSION_BRANCH)-latest
	- docker push $(MY_HUB_DOCKER)/$(APP):$(VERSION_BRANCH)-latest