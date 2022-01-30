package com.example.iptnews.view


import android.content.Intent
import android.os.Build
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.ListFragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iptnews.R
import com.example.iptnews.view.model.Noticias
import kotlinx.android.synthetic.main.fragment_details_news.view.*
import kotlinx.android.synthetic.main.newsitem.view.*
import kotlinx.android.synthetic.main.newsitem.view.listTitle
import kotlin.math.log

class ItemsAdapter (val newsList: ArrayList<Noticias>):RecyclerView.Adapter<ItemsAdapter.NewsViewHolder>() {


    fun updateNewsList(newNoticiaList: List<Noticias>) {

        newsList.clear()

        newsList.addAll(newNoticiaList)

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

        holder.view.listTitle.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(newsList[position].title, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(newsList[position].title)
        }

        holder.view.listDesc.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(newsList[position].description, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(newsList[position].description)
        }

        holder.view.listAuthor.text = newsList[position].author
        holder.view.listPubDate.text = newsList[position].pubDate
        Glide.with(holder.view.context)
            .load(newsList[position].enclosure?.link)
            .into(holder.view.listUrl)

        holder.view.setOnClickListener{
            Navigation.findNavController(it).navigate(LatestFragmentDirections.actionLatestDetails(newsList[position]))
        }

    }

    override fun getItemCount() = newsList.size


}

