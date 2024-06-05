package producer.application

import invoice.domain.Invoice

interface ProducerService {
    fun produce(supplies: List<Invoice>)
}