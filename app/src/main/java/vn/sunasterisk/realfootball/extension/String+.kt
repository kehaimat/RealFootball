package vn.sunasterisk.realfootball.extension

import java.text.SimpleDateFormat
import java.util.*

fun String.formatDate(dateEvent: String?): String {
    dateEvent?.let {
        val pattern = "EEE, d MMM yyyy"
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.parse(it)
        dateFormat.applyPattern(pattern)
        return dateFormat.format(date)
    }
    return ""
}

fun String.getHour(strTime: String?): String? {
    strTime?.let {
        val pattern = "HH:mm"
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val date = dateFormat.parse(it)
        dateFormat.applyPattern(pattern)
        return dateFormat.format(date)
    }
    return ""
}

fun String.formatNumber(): String {
    if (this.isBlank()) return "-"
    val regex = """[\d]*\.[\d]*""".toRegex().find(this)?.value
    return regex ?: "-"
}

