package com.kwdevs.kwwidgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text

@Composable
fun Label(text:String,
          textAlign:TextAlign=TextAlign.Center,
          color: Color =Color.Black,
          fontSize:Int=12,
          fontWeight: FontWeight= FontWeight.Normal,
          maximumLines:Int=1,
          paddingStart:Int=0,
          paddingEnd:Int=0,
          paddingTop:Int=0,
          paddingBottom:Int=0,
          softWrap:Boolean=true,
          textOverflow: TextOverflow=TextOverflow.Clip,
          fontFamily: FontFamily=montaserFont){
    Box(modifier=Modifier
        .padding(start = paddingStart.dp, end = paddingEnd.dp,
            top = paddingTop.dp, bottom = paddingBottom.dp),
        contentAlignment = Alignment.Center){
        Text(text=text, textAlign = textAlign,
            color = color, fontSize = fontSize.sp,
            maxLines = maximumLines,
            lineHeight = TextUnit(value = fontSize.toFloat(),type = TextUnitType.Sp),
            softWrap = softWrap,
            fontFamily = fontFamily,
            overflow = textOverflow,
            fontWeight = fontWeight)
    }
}

@Composable
fun Label(label:String,
          text:String,
          textAlign: TextAlign=TextAlign.Center,
          color:Color=Color.Black,
          fontSize:Int=14,
          fontWeight: FontWeight= FontWeight.Normal,
          space:Int=5,
          labelColor:Color=Color.Black,
          labelFontSize:Int=14,
          maximumLines:Int=1,
          softWrap:Boolean=true,
          textOverflow: TextOverflow=TextOverflow.Clip,
          labelFontWeight: FontWeight= FontWeight.Normal,
){
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){
        Text(text="$label:",
            textAlign = textAlign,
            color = labelColor,
            maxLines = maximumLines,
            softWrap = softWrap,
            fontFamily = montaserFont,

            overflow = textOverflow,
            fontSize = labelFontSize.sp, fontWeight = labelFontWeight)

        HorizontalSpacer(space)

        Text(text=text, textAlign = textAlign, color = color,
            maxLines = maximumLines,
            fontFamily = montaserFont,

            fontSize = fontSize.sp, fontWeight = fontWeight)

    }
}

@Composable
fun Label(label:String,
          text:String,
          textAlign: TextAlign=TextAlign.Center,
          color:Color=Color.Black,
          fontSize:Int=14,
          fontWeight: FontWeight= FontWeight.Normal,
          space:Int=5,
          labelColor:Color=Color.Black,
          labelFontSize:Int=14,
          labelFontWeight: FontWeight= FontWeight.Normal,
          @DrawableRes icon:Int,
          iconSize:Int=26,
          iconBackground:Color=Color.White,
          iconBackgroundSize:Int=26
){
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){
        Icon(icon=icon, background = iconBackground, size = iconSize, containerSize = iconBackgroundSize)
        HorizontalSpacer()
        Text(text=label, textAlign = textAlign,
            fontFamily = montaserFont,

            color = labelColor,
            fontSize = labelFontSize.sp, fontWeight = labelFontWeight)

        HorizontalSpacer(space)

        Text(text=text,
            fontFamily = montaserFont,

            textAlign = textAlign, color = color,
            fontSize = fontSize.sp, fontWeight = fontWeight)

    }
}
