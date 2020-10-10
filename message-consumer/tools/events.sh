#!/bin/bash

# events
java -jar event-generators-1.1-jar-with-dependencies.jar \
  events --debug --target http://localhost:8080/events/process