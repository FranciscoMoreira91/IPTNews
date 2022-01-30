@file:Suppress("DEPRECATION")

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.iptnews.view.*


internal class MyAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                LatestFragment()
            }
            1 -> {
                WorldFragment()
            }
            2 -> {
                SportsFragment()
            }
            3 -> {
                EconomyFragment()
            }
            4 -> {
                PoliticsFragment()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
}