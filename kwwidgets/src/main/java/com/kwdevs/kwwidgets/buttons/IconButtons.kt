package com.kwdevs.kwwidgets.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.kwdevs.kwwidgets.Icon


@Composable
fun IconButton(@DrawableRes icon:Int, background: Color = Color.White,
               size: Int=26,
               paddingTop:Int=0,
               paddingBottom:Int=0,
               paddingStart:Int=0,
               paddingEnd:Int=0,
               containerSize: Int=26, onClick:()->Unit){
    Box(modifier= Modifier
        .padding(top=paddingTop.dp, bottom = paddingBottom.dp, start = paddingStart.dp,end=paddingEnd.dp)
        .background(color = background, shape = CircleShape)
        .clip(CircleShape)
        .clickable {
            try{ onClick.invoke() } catch (e:Exception){e.printStackTrace()} },
        contentAlignment = Alignment.Center){
        Icon(icon, size = size,
            containerSize = containerSize,
            background = background)
    }
}

@Composable
fun IconButton(@DrawableRes icon:Int, background: Color = Color.White,
               size: Int=26,
               paddingTop:Int=0,
               paddingBottom:Int=0,
               paddingStart:Int=0,
               paddingEnd:Int=0,
               elevation:Int=5,
               containerSize: Int=26, onClick:()->Unit){
    Box(modifier= Modifier
        .padding(top=paddingTop.dp, bottom = paddingBottom.dp, start = paddingStart.dp,end=paddingEnd.dp)
        .shadow(elevation=elevation.dp, shape = CircleShape)
        .background(color = background, shape = CircleShape)
        .clip(CircleShape)
        .clickable { onClick.invoke() },
        contentAlignment = Alignment.Center){
        Icon(icon, size = size,
            containerSize = containerSize,
            background = background)
    }
}
