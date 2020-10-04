package edu.uoc.pac1ex2androidav.model

import java.io.Serializable
import java.util.*

data class BookItem(
    var identificador: Int,
    var titol: String,
    var autor: String,
    var dataPublicacio: Date,
    var descripcio: String,
    var imatge: String) : Serializable {
    constructor() : this(0,"","",Date(), "", "")
}