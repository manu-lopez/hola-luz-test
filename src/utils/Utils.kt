package utils

import java.math.RoundingMode

object Utils {
    fun round(decimals: Int, value: Double): Double = value.toBigDecimal().setScale(decimals, RoundingMode.HALF_UP).toDouble()
}