package com.chocomiruku.homework1

import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

fun formatPrice(price: Double) : String {
    val formatter: NumberFormat = NumberFormat.getCurrencyInstance()
    formatter.currency = Currency.getInstance("EUR")

    return formatter.format(price)
}

fun convertLongToTimeString(systemTime: Long): String {
    return SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        .format(systemTime).toString()
}