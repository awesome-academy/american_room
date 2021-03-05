package com.sun.americanroom.screen.main.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.american_room.screen.utils.MenuItem
import com.sun.americanroom.R
import com.sun.americanroom.screen.explore.ExploreFragment
import com.sun.americanroom.screen.favorite.FavoriteFragment
import com.sun.americanroom.screen.new.NewFragment
import com.sun.americanroom.screen.top.TopFragment
import com.sun.americanroom.utils.Constant
import kotlinx.android.synthetic.main.first_fragment.*

class FirstFragment : Fragment() {
    private val fragments = mutableListOf<Fragment>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListFragment()
        fragmentManager?.let {
            viewPagerContainer.adapter = ViewPagerContainerAdapter(it, fragments)
            initItemBottomBar()
        }
    }

    private fun initListFragment() {
        fragments.apply {
            add(MenuItem.EXPLORE.ordinal, ExploreFragment.newInstance())
            add(MenuItem.TOP.ordinal, TopFragment.newInstance())
            add(MenuItem.NEW.ordinal, NewFragment.newInstance())
            add(MenuItem.FAVORITE.ordinal, FavoriteFragment.newInstance())
        }
    }

    private fun initItemBottomBar() {
        textViewTitle.text=Constant.TEXT_EXPLORE
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itExplore-> {
                    viewPagerContainer.currentItem = MenuItem.EXPLORE.ordinal
                    textViewTitle.text=Constant.TEXT_EXPLORE
                    true
                }
                R.id.itTop -> {
                    viewPagerContainer.currentItem = MenuItem.TOP.ordinal
                    textViewTitle.text=Constant.TEXT_TOP
                    true
                }
                R.id.itNew -> {
                    viewPagerContainer.currentItem = MenuItem.NEW.ordinal
                    textViewTitle.text=Constant.TEXT_NEW
                    true
                }
                R.id.itFavorite -> {
                    viewPagerContainer.currentItem = MenuItem.FAVORITE.ordinal
                    textViewTitle.text=Constant.TEXT_FAVORITE
                    true
                }
                else ->
                    false
            }

        }
        viewPagerContainer.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) = Unit

            override fun onPageSelected(position: Int) {
                bottomNav.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(state: Int) = Unit
        })
    }

    companion object {
        fun newInstance() = FirstFragment()
    }
}
