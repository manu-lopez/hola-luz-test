package producer.application

import invoice.domain.Invoice

class ProducerServiceImpl(private val producerService: ProducerService) {
    fun produceData(supplies: List<Invoice>){
        producerService.produce(supplies)
    }
}