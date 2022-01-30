package com.example.iptnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iptnews.view.ItemsAdapter
import com.example.iptnews.view.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list_news.*


class LatestFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
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

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        NewsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newslistadapter

        }

        refreshLayout.setOnRefreshListener {
            NewsList.visibility = View.GONE
            listError.visibility = View.GONE
            loadingView.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
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