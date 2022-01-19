package com.example.iptnews.view


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iptnews.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ItemsAdapter.ClickListener{

    private lateinit var navController : NavController

    val itemsModalList = ArrayList<Noticias>()

    var itemsAdapter : ItemsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navController = Navigation.findNavController(this, R.id.fragmentContainerView)
        NavigationUI.setupActionBarWithNavController(this, navController)


        itemsAdapter = ItemsAdapter(this)
        itemsAdapter!!.setData(itemsModalList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = itemsAdapter

    }


    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu , menu)

        val menuItem = menu!!.findItem(R.id.searchView)

        val searchView = menuItem.actionView as SearchView

        searchView.maxWidth = Int.MAX_VALUE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(filterString: String?): Boolean {
                itemsAdapter!!.filter.filter(filterString)
                return true
            }

            override fun onQueryTextChange(filterString: String?): Boolean {

                itemsAdapter!!.filter.filter(filterString)
                return true
            }

        })

        return true
    }

    override fun ClickedItem(itemsModal: Noticias) {
        Log.e("TAG", itemsModal.titulo)

        when(itemsModal.titulo){
            "titulo" ->
                startActivity(Intent(this@MainActivity, fragmentDetailsNews::class.java))
        }

    }

}

