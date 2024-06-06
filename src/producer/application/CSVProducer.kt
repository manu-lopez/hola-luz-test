package producer.application

import invoice.domain.Invoice
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class CSVProducer: ProducerService {
    override fun produce(supplies: List<Invoice>) {
        val path = File("./CSV_GENERATED")
        val file = "${path}/invoices.csv"

        if(!path.exists()) path.mkdirs()

        FileOutputStream(file).apply { writeCSV(supplies) }
    }

    private fun OutputStream.writeCSV(supplies: List<Invoice>){
        val writer = bufferedWriter()
        writer.write("SUPPLY_POINT;TOTAL_AMOUNT")
        writer.newLine()
        supplies.forEach{
            writer.write("${it.supplyPoint};${it.amount}")
            writer.newLine()
        }
        writer.flush()

        println("CSV created")
    }
}