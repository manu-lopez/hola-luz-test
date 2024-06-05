package producer.application

import invoice.domain.Invoice
import java.io.FileOutputStream
import java.io.OutputStream

class CSVProducer: ProducerService {
    override fun produce(supplies: List<Invoice>) {
        FileOutputStream("invoices.csv").apply { writeCSV(supplies) }
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
    }
}