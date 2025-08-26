package com.kwdevs.kwwidgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Icon(@DrawableRes icon: Int, background: Color = Color.White,
         size:Int=26,
         containerSize:Int=26,
         contentDescription:String?=null,
         shape: Shape = CircleShape
){
    Box(modifier= Modifier.size((containerSize).dp)
        .background(color = background, shape = shape)
        .clip(shape),
        contentAlignment = Alignment.Center){
        Image(modifier= Modifier.size(size.dp),painter= painterResource(icon), contentDescription = contentDescription )
    }
}