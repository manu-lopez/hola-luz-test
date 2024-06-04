import consumer.application.CSVConsumer
import consumer.application.ConsumerService

fun main() {
    val csvConsumer = ConsumerService(CSVConsumer())
    val supplyData = csvConsumer.getData()
}
