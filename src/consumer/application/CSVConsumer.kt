package consumer.application

import consumer.domain.Supply

class CSVConsumer: ConsumerService {
    override fun consume(): List<Supply> {
        return readCSV()
    }

    private fun readCSV(): List<Supply> {
        val csvText = this.javaClass.classLoader.getResource("NOVEMBER_DATA_TO_BE_INVOICED.csv")?.readText()

        if (csvText.isNullOrBlank()){
            throw Error("File not found")
        }

        val list = csvText.lineSequence().drop(1).filter { it.isNotBlank() }
            .map {
                val (supplyPoint, energyConsumption, periodOnePower, periodTwoPower) = it.split(";")
                Supply(supplyPoint, energyConsumption.toInt(), periodOnePower.toDouble(), periodTwoPower.toDouble())
            }.toList()

        return list
    }
}