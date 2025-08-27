package com.kwdevs.kwwidgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.LayoutDirection
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


@Composable
fun LabelSpan(value:String, label:String, labelColor:Color= blackColor(LocalContext.current),
              labelWeight: FontWeight=FontWeight.Bold,
              spanColor: Color= blueColor(LocalContext.current), maximumLines:Int=1,
              layoutDirection: ProvidedValue<LayoutDirection> = RIGHT_LAYOUT_DIRECTION){
    CompositionLocalProvider(layoutDirection) {
        Row(verticalAlignment = Alignment.CenterVertically){
            HorizontalSpacer()
            if(value.trim()!=""){
                Span(text=value, backgroundColor = spanColor, color = Color.White, maximumLines = maximumLines)
                HorizontalSpacer()
            }
            Label(text=label, color = labelColor, fontWeight = labelWeight , textOverflow = TextOverflow.Ellipsis, softWrap = true)
            HorizontalSpacer()
        }


    }
}
