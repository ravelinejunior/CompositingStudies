package com.raveline.compositing.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.toDollar():String{
    return NumberFormat.getCurrencyInstance(
      Locale("EN","US")
    ).format(this)
}