#!/bin/sh
kill $(lsof -t -i:4200)
kill $(lsof -t -i:8901)
kill $(lsof -t -i:8885)
kill $(lsof -t -i:8886)
kill $(lsof -t -i:8887)
kill $(lsof -t -i:8888)
kill $(lsof -t -i:8889)
kill $(lsof -t -i:8080)
kill $(lsof -t -i:8761)

echo "Stopped all ms's"
