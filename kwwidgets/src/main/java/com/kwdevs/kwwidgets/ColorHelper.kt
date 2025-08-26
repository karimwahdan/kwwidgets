package com.kwdevs.kwwidgets

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat


fun grayColor(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.gray)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}

fun greenColor(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.green)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}

fun paleOrangeColor(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.pale_orange)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}

fun whiteColor(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.white)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}

fun blackColor(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.black)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}

fun blueColor(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.blue)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}

fun pinkColor(context:Context): Color {
    val colorInt= ContextCompat.getColor(context,R.color.pink)
    val colorString=String.format("#%06X",0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}

fun blue2Color(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.blue2)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}
fun blue3Color(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.blue3)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}
fun teal700Color(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.teal_700)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}

fun teal200Color(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.teal_200)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}

fun yellow(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.yellow)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}

fun orange(context:Context): Color {
    val colorInt = ContextCompat.getColor(context, R.color.orange)
    val colorString = String.format("#%06X", 0xFFFFFF and colorInt)
    return hexToComposeColor(colorString)
}