#!/bin/sh

# Change this to your JDK installation root
#
#JAVA_HOME=/usr/java/j2sdk1.4.0_01

JRE=$JAVA_HOME/jre
JAVA=$JRE/bin/java

QUARTZ=../..

. ${QUARTZ}/examples/bin/buildcp.sh

# Uncomment the following line if you would like to set log4j 
# logging properties
#
#LOGGING_PROPS="-Dlog4j.configuration=log4j.properties"

# Set the name and location of the client.properties file
QUARTZ_PROPS="-Dorg.quartz.properties=client.properties"

$JAVA -classpath $QUARTZ_CP $QUARTZ_PROPS $LOGGING_PROPS org.quartz.examples.example12.RemoteClientExample

