#!/bin/bash
nohup java -Xms1024m -Xmx1024m -jar -Dspring.profiles.active=real c-crew-server-20220801.war 1> /dev/null 2>&1 &
