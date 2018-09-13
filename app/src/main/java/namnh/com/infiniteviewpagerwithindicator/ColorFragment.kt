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
    private var color: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
        args?.let {
            color = it.getInt("color")
            identifier = it.getInt("identifier")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val textView = TextView(activity)
        textView.gravity = Gravity.CENTER
        textView.textSize = 40f
        textView.setTextColor(Color.BLACK)
        textView.setBackgroundColor(color)
        textView.text = "Fragment ID: $identifier"
        return textView
    }
}