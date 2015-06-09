#!/bin/bash
export NLS_LANG=AMERICAN_AMERICA.AL32UTF8
export LANG=en_US.utf8

log()
{
    echo "[$(date +%F\ %T)] $@"
}

logn()
{
    echo -n "[$(date +%F\ %T)] $@"
}

log "+--------------------------------+"
log "|        BROTHERS CALENDAR DB    |"
log "|              UPDATE            |"
log "+--------------------------------+"

# fill variables. begin
DEFAULT_URL="jdbc:postgresql://192.168.1.200:5432"
DEFAULT_USR="postgres"

if [ _$1 == "_" ]; then # url not specified
    logn "Enter url for database (default is $DEFAULT_URL):"
    read URL
    if [ _$URL == "_" ]; then
        URL=$DEFAULT_URL;
    fi
else
    URL=$1;
fi

if [ _$2 == "_" ]; then # password not specified
    logn "Enter password for database superuser:"
    read -s EDB_PWD
else
    EDB_PWD=$2;
fi

if [ _$3 == "_" ]; then # user not specified
    logn "Enter superuser name (default is $DEFAULT_USR):"
    read EDB_USR
    if [ _$EDB_USR == "_" ]; then
        EDB_USR=$DEFAULT_USR;
    fi
else
    EDB_USR=$3;
fi
# fill variables. end

log "Running UPDATE using url: $URL"

./liquibase --driver=org.postgresql.Driver --username=$EDB_USR --changeLogFile=initial_calendar.xml --url=$URL/postgres --password=$EDB_PWD update
if [ $? -ne 0 ]
then
exit 1
fi

./liquibase --driver=org.postgresql.Driver --username=$EDB_USR --changeLogFile=prerun_calendar.xml --url=$URL/calendar_db --password=$EDB_PWD update
if [ $? -ne 0 ]
then
exit 1
fi

./liquibase --driver=org.postgresql.Driver --username=$EDB_USR --changeLogFile=master_calendar.xml --url=$URL/calendar_db --password=$EDB_PWD update
if [ $? -ne 0 ]
then
exit 1
fi

./liquibase --driver=org.postgresql.Driver --username=$EDB_USR --changeLogFile=postrun_calendar.xml --url=$URL/calendar_db --password=$EDB_PWD update
if [ $? -ne 0 ]
then
exit 1
fi


