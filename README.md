An sample for infinitely ViewPager with indicator.
This is optimized code from other source code that I found from the internet.

![Demo](/gif/demo.gif)

### Features

`ViewIndicator`: Can use for both `Infinity` and `Non-Infinity ViewPager`
- Circle indicator with custom `selectedColor` and `deselectedColor`
- Custom `selectedDrawable` and `deselectedDrawable`
- Scale animation with custom scale factor
- Auto select indicator correct when ViewPager auto change

`InfinityPagerAdapter`: wrapped pager adapter use to convert your normal
`PagerAdapter` to the infinity adapter.

`InfinityViewPager`:
- Auto scroll / change selected content
- Custom interval time that auto scroll /change selected content
- Set auto scroll with animation or not
- Cancel auto scroll when user touch down, and continue auto scroll when user touch up
- Keep last position when user pause app or ViewPager is out of screen (in case it's in RecyclerView)

### Usage
Your `Activity` or `Fragment` XML layout file:

```XML
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

    <namnh.com.infiniteviewpagerwithindicator.views.InfiniteViewPager
        android:id="@+id/pager"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:background="@color/colorAccent"
        app:autoSmoothScroll="true"
        app:autoScrollInterval="2000"
        />
    <namnh.com.infiniteviewpagerwithindicator.views.ViewPagerIndicator
        android:id="@+id/pager_indicator"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        app:animationDuration="100"
        app:animationScale="1.4"
        app:deselectedDrawable="@android:drawable/presence_invisible"
        app:enableAnimation="true"
        app:indicatorSpacing="5dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/pager"
        app:selectedDrawable="@android:drawable/presence_online"
        />
</android.support.constraint.ConstraintLayout>

```

From your `Activity` or `Fragment` code
```Kotlin
    // Create a simple normal pager adapter
    private val adapter = object : FragmentPagerAdapter(supportFragmentManager) {
        // TODO Add your adapter code
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
```

That's all !