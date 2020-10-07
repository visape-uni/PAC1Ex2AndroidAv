package edu.uoc.pac1ex2androidav.model

import java.util.*
import kotlin.collections.ArrayList

public class BookModel {
    val ITEMS: MutableList<BookItem> = ArrayList()

    init
    {
        val book1 =  BookItem(0, "Title1", "Author1", Date(), "Description 1", "")
        val book2 =  BookItem(1, "Title2", "Author2", Date(), "Description 2", "")
        ITEMS.add(book1)
        ITEMS.add(book2)
    }
}