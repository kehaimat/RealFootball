package vn.sunasterisk.realfootball.extension

import java.text.SimpleDateFormat
import java.util.*

fun String.formatDate(): String {
    if (this.isBlank()) return ""
    val pattern = "EEE, d MMM yyyy"
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val date = dateFormat.parse(this)
    dateFormat.applyPattern(pattern)
    return dateFormat.format(date)
}

fun String.getHour(): String? {
    if (this.isBlank()) return ""
    val pattern = "HH:mm"
    val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val date = dateFormat.parse(this)
    dateFormat.applyPattern(pattern)
    return dateFormat.format(date)
}

fun String.formatNumber(): String {
    if (this.isBlank()) return "-"
    val regex = """[\d]*\.[\d]*""".toRegex().find(this)?.value
    return regex ?: "-"
}

fun String.format():String{
    if (this.isBlank()) return "-"
    return this.replace(";\\s?".toRegex(), "\n")
}

