package invoice.application

import consumer.domain.Supply
import invoice.domain.Invoice
import utils.Utils

class InvoiceServiceImpl: InvoiceService {

    private val P1_PRICE = 2.180336
    private val P2_PRICE = 0.095261
    private val ENERGY_PRICE = 0.3428
    private val IVA = 5.0

    override fun calculateMonthlyInvoice(supplies: List<Supply>): List<Invoice> {
        if (supplies.isEmpty()) throw Error("Empty supply list")

        return supplies.map(::calculatePrice)
    }

    private fun calculatePrice(supply: Supply): Invoice{
        if (supply.periodOnePower < 0 || supply.periodTwoPower < 0 || supply.energyConsumption < 0) throw Error("Supply has negative values")

        val total = ((supply.periodOnePower * P1_PRICE) + (supply.periodTwoPower * P2_PRICE) + (supply.energyConsumption * ENERGY_PRICE)) * (1 + IVA/100)

        return Invoice(supply.supplyPoint, Utils.round(2, total))
    }
}