package consumer.application

import consumer.domain.Supply

interface ConsumerService {
    fun consume(): List<Supply>
}