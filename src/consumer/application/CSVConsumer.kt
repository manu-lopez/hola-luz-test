package consumer.application

import consumer.domain.Supply
import java.io.InputStream

class CSVConsumer: ConsumerService {
    override fun consume(): List<Supply> {
        return readCSV()
    }

    private fun readCSV(): List<Supply> {
        val csvText = getResourceAsString("NOVEMBER_DATA_TO_BE_INVOICED.csv")

        val list = csvText.lineSequence().drop(1).filter { it.isNotBlank() }
            .map {
                val (supplyPoint, energyConsumption, periodOnePower, periodTwoPower) = it.split(";")
                Supply(supplyPoint, energyConsumption.toInt(), periodOnePower.toDouble(), periodTwoPower.toDouble())
            }.toList()

        return list
    }

    private fun getResourceAsString(resourcePath: String): String {
        val inputStream: InputStream = this::class.java.classLoader.getResourceAsStream(resourcePath)
            ?: throw IllegalArgumentException("Resource $resourcePath not found")
        return inputStream.bufferedReader().use { it.readText() }
    }
}