package edu.uoc.pac1ex2androidav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uoc.pac1ex2androidav.model.BookItem
import kotlinx.android.synthetic.main.activity_book_detail.*

class BookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val item = intent.getSerializableExtra("item") as BookItem
        app_bar.title = "Item " + item.titol
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""

        supportFragmentManager.beginTransaction().replace(frameLayoutDetail.id, BookDetailFragment.newInstance(item)).commit()
    }
}