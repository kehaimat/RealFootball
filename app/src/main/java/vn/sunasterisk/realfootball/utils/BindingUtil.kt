package vn.sunasterisk.realfootball.utils

import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import vn.sunasterisk.realfootball.constant.Constant
import vn.sunasterisk.realfootball.extension.formatDate
import vn.sunasterisk.realfootball.extension.getHour

object BindingUtil {
    @BindingAdapter("android:date")
    @JvmStatic
    fun bindDate(textView: TextView, date: String?) {
        date?.let {
            textView.text = it.formatDate()
        }
    }

    @BindingAdapter("android:hour")
    @JvmStatic
    fun bindHour(textView: TextView, hour: String?) {
        hour?.let {
            textView.text = it.getHour()
        }
    }

    @BindingAdapter("app:hideIfNext")
    @JvmStatic
    fun hideIfNext(view: View, type: String) {
        view.isVisible = type == Constant.TYPE_NEXT_MATCH
    }
}
