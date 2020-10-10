package edu.uoc.pac1ex2androidav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import edu.uoc.pac1ex2androidav.model.BookModel
import kotlinx.android.synthetic.main.activity_book_list.*

class BookListActivity : AppCompatActivity() {

    companion object {
        const val  LIST_SIZE = 15
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        omplirLlista()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater;
        inflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_order_autor -> ordenarPerAutor()
            R.id.action_order_title -> ordenarPerTitol()
        }
        return true
    }

    fun omplirLlista() {
        listView.setHasFixedSize(true)
        listView.layoutManager = LinearLayoutManager(this)

        val mTwoPane = frameLayoutList != null

        val adapter = MyAdapter(BookModel().ITEMS, mTwoPane)
        listView.adapter = adapter
    }

    fun ordenarPerTitol() {

    }

    fun ordenarPerAutor() {

    }

}