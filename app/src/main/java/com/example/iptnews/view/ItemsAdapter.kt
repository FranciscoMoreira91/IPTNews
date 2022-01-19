package com.example.iptnews.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.iptnews.R
import com.example.iptnews.view.ItemsAdapter.ItemsAdapterVH
import kotlinx.android.synthetic.main.fragment_list_news.view.*
import java.util.*
import kotlin.collections.ArrayList


class ItemsAdapter
    (var clickListener: ClickListener)
    : RecyclerView.Adapter<ItemsAdapterVH>(), Filterable {

    var itemsModalList = ArrayList<Noticias>()
    var itemsFilter = ArrayList<Noticias>()
    var items = ArrayList<Noticias>()

    fun setData(itemsModalList : ArrayList<Noticias>){
        this.itemsModalList = itemsModalList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        return ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.fragment_list_news,parent,false))
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {
        val itemsModal = itemsModalList[position]
        holder.titulo.text = itemsModal.titulo
        holder.autor.text = itemsModal.autor
        holder.desc.text = itemsModal.descr
        holder.image.setImageResource(itemsModal.imagem)
        holder.DataP.text = itemsModal.DataP

        holder.itemView.setOnClickListener{
            clickListener.ClickedItem(itemsModal)
        }
    }

    override fun getItemCount(): Int {
        return itemsModalList.size
    }

    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titulo = itemView.Titulo
        val autor = itemView.Autor
        val desc = itemView.Descricao
        val image = itemView.image
        val DataP = itemView.DataP

    }

    interface ClickListener{
        fun ClickedItem(itemsModal : Noticias)
    }

    override fun getFilter(): Filter {
        return object:Filter(){
            override fun performFiltering(charSequence: CharSequence?): FilterResults {

                val filterResults = FilterResults();
                if (charSequence == null || charSequence.length < 0){
                    filterResults.count = itemsFilter.size
                    filterResults.values = itemsFilter
                }else{

                    var searchChr = charSequence.toString().lowercase(Locale.getDefault())

                    val itemModal = ArrayList<Noticias>()

                    for (items in itemsFilter){
                        if (items.titulo.contains(searchChr) || items.descr.contains(searchChr))
                            itemModal.add(items)
                    }


                    filterResults.count = items.size
                    filterResults.values = items


                }

                return filterResults

            }


            override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {
                itemsFilter = filterResults!!.values as ArrayList<Noticias>
                notifyDataSetChanged()
            }

        }
    }


}