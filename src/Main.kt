import consumer.application.CSVConsumer
import consumer.application.ConsumerServiceImpl

fun main() {
    val csvConsumer = ConsumerServiceImpl(CSVConsumer())
    val supplyData = csvConsumer.getData()
}
