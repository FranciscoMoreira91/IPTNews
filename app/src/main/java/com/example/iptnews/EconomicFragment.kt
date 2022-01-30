package com.example.iptnews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iptnews.databinding.FragmentListNewsBinding
import com.example.iptnews.view.fragmentListNews


class EconomicFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentListNewsBinding.inflate(layoutInflater)
        val fragmenteconomic = fragmentListNews()

        bind.btnToEconomic.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragmentContainerView, fragmenteconomic, fragmentListNews::class.java.simpleName )
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_economic, container, false)
    }


}