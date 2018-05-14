#!/bin/sh
cd ..
DEPLOY_DIR=`pwd`
LOG_HOME=$DEPLOY_DIR/logs
LIB_DIR=$DEPLOY_DIR/lib
CONF_DIR=$DEPLOY_DIR/conf
STDOUT_FILE=$LOG_HOME/console.log
SERVER_NAME="pt"

if [ ! -d $LOG_HOME ]; then
   mkdir $LOG_HOME
fi


PIDS=`ps  --no-heading -C java -f --width 1000 | grep "$DEPLOY_DIR" |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The $SERVER_NAME already started!"
    echo "PID: $PIDS"
    exit 1
fi

LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`

JAVA_DEBUG_OPTS=""
if [ "$1" = "debug" ]; then
    JAVA_DEBUG_OPTS=" -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n "
fi

echo -e "Starting the $SERVER_NAME ...\c"
java $JAVA_DEBUG_OPTS   -classpath $CONF_DIR:$LIB_JARS com.ai.oidd.cuckoo.home.HomeApplication  >$STDOUT_FILE &


COUNT=0
while [ $COUNT -lt 1 ]; do
   echo -e ".\c"
   sleep 1
   COUNT=`ps  --no-heading -C java -f --width 1000 | grep "$DEPLOY_DIR" | awk '{print $2}' | wc -l`
if [ $COUNT -gt 0 ]; then
    break
fi
done
echo "OK!"
PIDS=`ps  --no-heading -C java -f --width 1000 | grep "$DEPLOY_DIR" | awk '{print $2}'`
echo "PID: $PIDS"
echo "STDOUT: $STDOUT_FILE"