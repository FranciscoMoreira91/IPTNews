package com.example.iptnews.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iptnews.*
import com.example.iptnews.databinding.FragmentListNewsBinding
import com.example.iptnews.view.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_details_news.*
import kotlinx.android.synthetic.main.fragment_list_news.*


class fragmentListNews : Fragment(){


    private lateinit var viewModel: ListViewModel
    private val newslistadapter = ItemsAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentListNewsBinding.inflate(layoutInflater)
        val fragmenteconomic = EconomicFragment()

        bind.btnToEconomic.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragmenteconomic, EconomicFragment::class.java.simpleName )
                    .addToBackStack(null)
                    .commit()
            }
        }
        val fragmentpolitica = PoliticaFragment()

        bind.btnToPolitica.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragmentpolitica, PoliticaFragment::class.java.simpleName )
                    .addToBackStack(null)
                    .commit()
            }
        }
        val fragmentsport = SportsFragment()

        bind.btnToSport.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragmentsport, SportsFragment::class.java.simpleName )
                    .addToBackStack(null)
                    .commit()
            }
        }


        val fragmentmundo = MundoFragment()
        bind.btnToMundo.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragmentmundo, MundoFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }}

        return bind.root

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