#!/bin/sh

# You May Need To Change this to your Quartz installation root
QUARTZ=../..

QUARTZ_CP=""

for jarfile in $QUARTZ/*.jar; do
  QUARTZ_CP=$QUARTZ_CP:$jarfile
done

for jarfile in $QUARTZ/examples/*.jar; do
  QUARTZ_CP=$QUARTZ_CP:$jarfile
done

for jarfile in $QUARTZ/build/*.jar; do
  QUARTZ_CP=$QUARTZ_CP:$jarfile
done

for jarfile in $QUARTZ/examples/build/*.jar; do
  QUARTZ_CP=$QUARTZ_CP:$jarfile
done

for jarfile in $QUARTZ/lib/*.jar; do
  QUARTZ_CP=$QUARTZ_CP:$jarfile
done

echo "Classpath: " $QUARTZ_CP

