package com.example.iptnews

import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.iptnews.view.DetailsNewsFragmentArgs
import com.example.iptnews.view.model.Noticias
import com.example.iptnews.view.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_details_news.*

class LatestDetailsFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var detalhes: Noticias

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_news, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            detalhes = DetailsNewsFragmentArgs.fromBundle(it).detalhes
        }
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(detalhes)


        observeViewModel()
    }

    private fun observeViewModel () {

        viewModel.news.observe(viewLifecycleOwner, Observer { news ->
            news?.let {
                Glide.with(detailsImage.context)
                    .load(news.enclosure?.link)
                    .into(detailsImage)
                detailsTitle.text = news.title
                detailsAuthor.text = news.author
                detailsPubDate.text = news.pubDate
                detailsContent.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Html.fromHtml(news.content, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    Html.fromHtml(news.content)
                }
            }
        })

    }
}