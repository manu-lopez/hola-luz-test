package consumer.application

import consumer.domain.Supply

class ConsumerService(private val consumer: Consumer) {
    fun getData(): List<Supply>{
        return consumer.consume()
    }
}