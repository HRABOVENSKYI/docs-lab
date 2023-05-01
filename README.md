# docs-lab
Create topic:
docker exec kafka kafka-topics --bootstrap-server kafka:9092 --create --topic quickstart

Produce messages:
docker exec --interactive --tty kafka kafka-console-producer --bootstrap-server kafka:9092 --topic quickstart

Consume messages:
docker exec --interactive --tty kafka kafka-console-consumer --bootstrap-server kafka:9092 --topic quickstart --from-beginning

