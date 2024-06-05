import consumer.application.CSVConsumer
import consumer.application.ConsumerServiceImpl
import invoice.application.InvoiceServiceImpl
import producer.application.CSVProducer
import producer.application.ProducerServiceImpl

fun main() {
    val csvConsumer = ConsumerServiceImpl(CSVConsumer())
    val supplyData = csvConsumer.getData()

    val invoiceServiceImpl = InvoiceServiceImpl()
    val invoices = invoiceServiceImpl.calculateMonthlyInvoice(supplyData)

    val csvProducer = ProducerServiceImpl(CSVProducer())
    csvProducer.produceData(invoices)
}
