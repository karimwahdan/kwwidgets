package com.kwdevs.kwwidgets.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kwdevs.kwwidgets.LOADING_LABEL
import com.kwdevs.kwwidgets.Label
import com.kwdevs.kwwidgets.R
import com.kwdevs.kwwidgets.VerticalSpacer
import com.kwdevs.kwwidgets.teal700Color

@Composable
fun LoadingScreen(modifier: Modifier =Modifier){
    Column(modifier=modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            modifier=Modifier.size(72.dp),
            painter = painterResource(R.drawable.logo),
            contentScale = ContentScale.FillBounds,
            contentDescription = null)
        CircularProgressIndicator(color = teal700Color(LocalContext.current))
        VerticalSpacer()
        Label(text=LOADING_LABEL)
    }
}