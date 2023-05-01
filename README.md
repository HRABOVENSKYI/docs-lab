# docs-lab
### HOW TO RUN:
1. ``docker compose up -d``
2. Create ``.env`` file. Example:
```
WRITE_TYPE=KAFKA
KAFKA_TOPIC=quickstart
```
3. Run DocsLabApplication locally. Add ``.env`` to its configuration.


### INFO:
Create topic:
``docker exec kafka kafka-topics --bootstrap-server kafka:9092 --create --topic quickstart``

Produce messages:
``docker exec --interactive --tty kafka kafka-console-producer --bootstrap-server kafka:9092 --topic quickstart``

Consume messages:
``docker exec --interactive --tty kafka kafka-console-consumer --bootstrap-server kafka:9092 --topic quickstart --from-beginning``

