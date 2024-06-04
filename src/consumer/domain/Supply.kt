package consumer.domain

data class Supply(
    val supplyPoint: String,
    val energyConsumption: Int,
    val periodOnePower: Double,
    val periodTwoPower: Double
)
