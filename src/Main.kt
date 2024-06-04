import consumer.application.CSVConsumer
import consumer.application.ConsumerServiceImpl
import invoice.application.InvoiceServiceImpl

fun main() {
    val csvConsumer = ConsumerServiceImpl(CSVConsumer())
    val supplyData = csvConsumer.getData()

    val invoiceServiceImpl = InvoiceServiceImpl()
    val invoices = invoiceServiceImpl.calculateMonthlyInvoice(supplyData)
}
