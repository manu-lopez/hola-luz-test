package consumer.application

import consumer.domain.Supply

interface Consumer {
    fun consume(): List<Supply>
}