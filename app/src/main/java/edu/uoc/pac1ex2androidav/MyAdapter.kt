package edu.uoc.pac1ex2androidav

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import edu.uoc.pac1ex2androidav.MyAdapter.MyViewHolder
import edu.uoc.pac1ex2androidav.model.BookItem
import kotlinx.android.synthetic.main.activity_book_list.*
import kotlinx.android.synthetic.main.activity_book_list.view.*
import java.util.*

class MyAdapter(private val mValues: MutableList<BookItem>, private val mTwoPane: Boolean) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View? = null
        view = LayoutInflater.from(parent.context)
            .inflate(
                if (viewType == PARELL) R.layout.elements_parells else R.layout.elements_imparells,
                parent,
                false
            )
        return MyViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            PARELL
        } else {
            IMPARELL
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.tvTitle.text = mValues[position].titol
        holder.tvAutor.text = mValues[position].autor
        holder.view!!.setOnClickListener {
            if(mTwoPane) {
                val fragment = BookDetailFragment.newInstance(holder.mItem!!)
                val activity = (it.context as AppCompatActivity)
                activity.supportFragmentManager.beginTransaction().replace(it.frameLayoutList.id, fragment).commit()
            } else {
                val newIntent = Intent(it.context, BookDetailActivity::class.java)
                newIntent.putExtra("item", holder.mItem)
                it.context.startActivity(newIntent)
            }
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    class MyViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        var mItem: BookItem? = null
        var tvTitle: TextView
        var tvAutor: TextView
        var view: View?

        init {
            tvTitle = view!!.findViewById(R.id.title)
            tvAutor = view.findViewById(R.id.autor)
            this.view = view
        }
    }

    companion object {
        private const val PARELL = 0
        private const val IMPARELL = 1
    }

}