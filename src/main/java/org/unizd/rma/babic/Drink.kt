package org.unizd.rma.babic

import java.io.Serializable

data class Drink(
    val idDrink: String,
    val strDrink: String,
    val strDrinkThumb: String
) : Serializable