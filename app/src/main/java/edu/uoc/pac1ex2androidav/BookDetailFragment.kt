package edu.uoc.pac1ex2androidav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.uoc.pac1ex2androidav.model.BookItem
import kotlinx.android.synthetic.main.fragment_book_detail.*
import java.text.DateFormat
import java.text.SimpleDateFormat

class BookDetailFragment : Fragment() {

    companion object {
        fun newInstance(item: BookItem) : BookDetailFragment {
            val fragment = BookDetailFragment()
            val args = Bundle()
            args.putSerializable("item", item)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = arguments?.getSerializable("item") as BookItem
        authorItem.text = item.autor
        val formatter = SimpleDateFormat("dd/MM/yyyy");
        dateItem.text = formatter.format(item.dataPublicacio)
        descriptionItem.text = item.descripcio
    }
}