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
    // Create a simple normal pager adapter
    private val adapter = object : FragmentPagerAdapter(supportFragmentManager) {
        var colors = intArrayOf(Color.CYAN, Color.GRAY, Color.MAGENTA, Color.LTGRAY,
                Color.GREEN, Color.WHITE, Color.YELLOW)

        override fun getCount(): Int {
            return colors.size
        }

        override fun getItem(position: Int): Fragment {
            val fragment = ColorFragment()
            val args = Bundle()
            args.putInt("color", colors[position])
            args.putInt("identifier", position)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // make your normal pager adapter to infinity pager adapter
        val wrappedAdapter = InfinitePagerAdapter(adapter)
        // setup wrapped infinity pager adapter to the InfiniteViewPager
        val viewPager = findViewById<InfiniteViewPager>(R.id.pager)
        viewPager.adapter = wrappedAdapter
        // setup the indicator for the InfiniteViewPager
        val viewPagerIndicator = findViewById<ViewPagerIndicator>(R.id.pager_indicator)
        viewPagerIndicator.setPager(viewPager)
    }
}
