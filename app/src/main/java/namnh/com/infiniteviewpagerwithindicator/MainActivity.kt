package namnh.com.infiniteviewpagerwithindicator

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import namnh.com.infiniteviewpagerwithindicator.views.InfinitePagerAdapter
import namnh.com.infiniteviewpagerwithindicator.views.InfiniteViewPager
import namnh.com.infiniteviewpagerwithindicator.views.ViewPagerIndicator

class MainActivity : AppCompatActivity() {
    private val adapter = object : FragmentPagerAdapter(supportFragmentManager) {
        var colours = intArrayOf(Color.CYAN, Color.GRAY, Color.MAGENTA, Color.LTGRAY,
            Color.GREEN, Color.WHITE, Color.YELLOW)

        override fun getCount(): Int {
            return colours.size
        }

        override fun getItem(position: Int): Fragment {
            val fragment = ColorFragment()
            val args = Bundle()
            args.putInt("color", colours[position])
            args.putInt("identifier", position)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // wrap pager to provide infinite paging with wrap-around
        val wrappedAdapter = InfinitePagerAdapter(adapter)

        // actually an InfiniteViewPager
        val viewPager = findViewById<InfiniteViewPager>(R.id.pager)
        viewPager.adapter = wrappedAdapter

        val viewPagerIndicator = findViewById<ViewPagerIndicator>(R.id.pager_indicator)
        viewPagerIndicator.setPager(viewPager)
    }
}
