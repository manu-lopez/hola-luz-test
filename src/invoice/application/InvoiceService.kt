package invoice.application

import consumer.domain.Supply
import invoice.domain.Invoice

interface InvoiceService {
    fun calculateMonthlyInvoice(supplies: List<Supply>): List<Invoice>
}