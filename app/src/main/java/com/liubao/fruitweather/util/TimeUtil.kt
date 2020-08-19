package com.liubao.fruitweather.util

import java.text.DateFormat
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

/**
 * Timestamp to String
 * @param Timestamp
 * @return String
 */
const val YY_MM_DD_HH_MM_SS = "yy-MM-dd HH:mm:ss"
const val YY_MM_DD = "yy-MM-dd"

fun transToString(time: Long, formatPattern: String = YY_MM_DD): String {
    val format: DateFormat = SimpleDateFormat(formatPattern)
    format.timeZone = TimeZone.getTimeZone("Asia/Shanghai")
    val date = Date(time)
    return format.format(date)
}


fun yearBetween(date1: Date?, date2: Date?) {

}

fun daysBetween(date1: Date?, date2: Date?): Int {
    val cal = Calendar.getInstance()
    cal.time = date1
    val time1 = cal.timeInMillis
    cal.time = date2
    val time2 = cal.timeInMillis
    val between_days = (time2 - time1) / (10003600 * 24)
    return abs(between_days.toInt())
}

/**
 * String to Timestamp
 * @param String
 * @return Timestamp
 */

fun transToTimeStamp(date: String): Long {
    return SimpleDateFormat("YY-MM-DD-hh-mm-ss").parse(date, ParsePosition(0)).time
}

fun newTime(ins: Calendar = Calendar.getInstance()): TimeModel {
    return TimeModel(
        ins.get(Calendar.YEAR),
        ins.get(Calendar.MONDAY),
        ins.get(Calendar.DAY_OF_MONTH) + 1,
        ins.get(Calendar.HOUR),
        ins.get(Calendar.MINUTE),
        ins.get(Calendar.SECOND)
    )

}

class TimeModel(
    val year: Int,
    val month: Int,
    val day: Int,
    val hour: Int,
    val minute: Int,
    val second: Int
) {

}