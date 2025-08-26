package com.kwdevs.kwwidgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


@Composable
fun Span(text:String,
         textAlign: TextAlign = TextAlign.Center,
         color: Color = Color.Black,
         fontSize:Int=14,
         fontWeight: FontWeight = FontWeight.Normal,
         backgroundColor: Color = Color.Gray,
         maximumLines:Int=1,
         startPadding:Int=0,
         endPadding:Int=0,
         topPadding:Int=0,
         bottomPadding:Int=0,
         backgroundShape: Shape = rcs(5)){
    Row(modifier= Modifier
        .padding(
            start=startPadding.dp,
            end=endPadding.dp,
            top=topPadding.dp,
            bottom =bottomPadding.dp )
        .background(color=backgroundColor, shape = backgroundShape),
        horizontalArrangement = Arrangement.Center){
        HorizontalSpacer(2)
        Label(text=text,textAlign=textAlign,color=color,fontSize=fontSize,fontWeight=fontWeight, maximumLines = maximumLines
            , softWrap = true, textOverflow = TextOverflow.Ellipsis)
        HorizontalSpacer(2)
    }

}