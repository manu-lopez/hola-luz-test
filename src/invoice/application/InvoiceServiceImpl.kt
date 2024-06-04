package invoice.application

import consumer.domain.Supply
import invoice.domain.Invoice

class InvoiceServiceImpl: InvoiceService {
    override fun calculateMonthlyInvoice(supplies: List<Supply>): List<Invoice> {
        TODO("Not yet implemented")
    }
}