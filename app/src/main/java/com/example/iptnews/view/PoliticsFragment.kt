package com.example.iptnews.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iptnews.R
import com.example.iptnews.view.viewmodel.PoliticsModel
import kotlinx.android.synthetic.main.fragment_details_news.*
import kotlinx.android.synthetic.main.fragment_list_news.*


class PoliticsFragment : Fragment(){


    private lateinit var viewModel: PoliticsModel
    private val newslistadapter = ItemsAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_news, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(PoliticsModel::class.java)
        viewModel.refresh()

        NewsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newslistadapter

        }

        refreshlayout.setOnRefreshListener {
            NewsList.visibility = View.GONE
            listError.visibility = View.GONE
            loadingView.visibility = View.VISIBLE
            viewModel.refresh()
            refreshlayout.isRefreshing = false
        }

        observeViewModel()

    }


    fun observeViewModel () {
        viewModel.news.observe(viewLifecycleOwner, Observer { news ->
            news?.let {
                NewsList.visibility = View.VISIBLE
                newslistadapter.updateNewsList(news)
            }
        })

        viewModel.NewsLoadError.observe(viewLifecycleOwner, Observer { isError ->
            isError?.let {
                if (it)
                    listError.visibility = View.VISIBLE
                else
                    listError.visibility = View.GONE
            }
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            isLoading?.let {
                loadingView.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    listError.visibility = View.GONE
                    NewsList.visibility = View.GONE
                }
            }
        })
    }

}