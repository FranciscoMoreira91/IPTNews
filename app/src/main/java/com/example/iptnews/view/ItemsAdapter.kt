package com.example.iptnews.view


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.recyclerview.widget.RecyclerView
import com.example.iptnews.R
import com.example.iptnews.view.model.Noticias
import kotlinx.android.synthetic.main.fragment_details_news.view.*
import kotlinx.android.synthetic.main.newsitem.view.*
import kotlinx.android.synthetic.main.newsitem.view.Titulo

class ItemsAdapter (val newList: ArrayList<Noticias>):RecyclerView.Adapter<ItemsAdapter.NewsViewHolder>() {

    fun updateNewsList(newNoticiaList: List<Noticias>) {

        newList.clear()

        newList.addAll(newNoticiaList)

        //Notifies the attached observers that the
        //underlying data has been changed and any View reflecting the data set should refresh itself
        notifyDataSetChanged()
    }


    class NewsViewHolder (var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.newsitem, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.view.Titulo.text = newList[position].titulo
        holder.view.descr.text = newList[position].descr
        holder.view.autor.text = newList[position].autor
        holder.view.DataP.text = newList[position].DataP
        holder.view.setOnClickListener{
            Navigation.findNavController(it).navigate(fragmentListNewsDirections.actionDetailsNews())
        }

    }

    override fun getItemCount() = newList.size


}

