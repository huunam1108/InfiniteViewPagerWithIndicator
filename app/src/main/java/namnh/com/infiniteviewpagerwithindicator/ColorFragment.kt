package namnh.com.infiniteviewpagerwithindicator

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ColorFragment : Fragment() {

    private var identifier: Int = 0
    private var colour: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        args?.let {
            colour = it.getInt("color")
            identifier = it.getInt("identifier")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val v = TextView(activity)
        v.gravity = Gravity.CENTER
        v.textSize = 40f
        v.setTextColor(Color.BLACK)
        v.setBackgroundColor(colour)
        v.text = "Fragment ID: $identifier"
        return v
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("dummy", true)
    }
}