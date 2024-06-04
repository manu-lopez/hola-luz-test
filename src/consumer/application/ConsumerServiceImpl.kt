package consumer.application

import consumer.domain.Supply

class ConsumerServiceImpl(private val consumerService: ConsumerService) {
    fun getData(): List<Supply>{
        return consumerService.consume()
    }
}