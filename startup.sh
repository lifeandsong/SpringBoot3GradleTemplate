#!/bin/sh

nohup java -jar /home/swmaestro/SpringBoot3GradleTemplate.jar 1> /dev/null 2>&1 &
# nohup java -jar -Dspring.profiles.active=dev /home/swmaestro/SpringBoot3GradleTemplate.jar 1> /dev/null 2>&1 &

echo SpringBoot3GradleTemplate has been started !
