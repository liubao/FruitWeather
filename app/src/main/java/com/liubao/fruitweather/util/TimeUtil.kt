package com.liubao.fruitweather.util

import java.text.DateFormat
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*

/**
 * Timestamp to String
 * @param Timestamp
 * @return String
 */
fun transToString(time: Long): String {
    val formatPattern = "yy-MM-dd HH:mm:ss"
    val format: DateFormat = SimpleDateFormat(formatPattern)
    format.timeZone = TimeZone.getTimeZone("Asia/Shanghai")
    val date = Date(time)
    return format.format(date)
}

/**
 * String to Timestamp
 * @param String
 * @return Timestamp
 */

fun transToTimeStamp(date: String): Long {
    return SimpleDateFormat("YY-MM-DD-hh-mm-ss").parse(date, ParsePosition(0)).time
}