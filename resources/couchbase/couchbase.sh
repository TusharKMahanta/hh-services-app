
DB_NAME="FPS_COUCHBASE"
START="start"
STOP="stop"

if [[ $1 == $START ]]; then
	echo "Starting $DB_NAME"
	if [ ! "$(docker ps -q -f name=$DB_NAME)" ]; then
		if [ "$(docker ps -aq -f status=exited -f name=$DB_NAME)" ]; then
			echo "Starting $DB_NAME"
			if [[ $2 == 'new' ]]; then
				docker rm $DB_NAME
				docker run --name $DB_NAME -p 8091-8094:8091-8094 -p 11210-11211:11210-11211 couchbase
			else
				docker start $DB_NAME
			fi
		else
			docker run --name $DB_NAME -p 8091-8094:8091-8094 -p 11210-11211:11210-11211 couchbase
		fi
	fi
fi
if [ $1 == $STOP ]; then
	echo "Stopping $DB_NAME"
	docker stop $DB_NAME
fi
