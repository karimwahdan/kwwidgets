package com.kwdevs.kwwidgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kwdevs.kwwidgets.buttons.IconButton


@Composable
fun BoxContainer(content:@Composable ()->Unit){
    Box(modifier= Modifier.fillMaxWidth().padding(5.dp)
        .shadow(elevation = 5.dp, shape = rcs(20))
        .background(color= Color.White,shape= rcs(20))
        .border(width=1.dp,color= Color.White,shape= rcs(20)),
        contentAlignment = Alignment.Center){
        content()
    }
}

@Composable
fun ColumnContainer(
    shape: Shape = rcs(20),
                    background: Color= Color.White,
                    borderColor: Color= Color.White,
                    content:@Composable ()->Unit){
    Column(modifier=Modifier.fillMaxWidth().padding(5.dp)
        .shadow(elevation = 5.dp, shape = shape)
        .background(color=background,shape= shape)
        .border(width=1.dp,color=borderColor,shape= shape),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        content()
    }
}

@Composable
fun PaginationContainer(
    shape: Shape= RectangleShape,
                        currentPage: MutableIntState,
                        lastPage:Int,
                        totalItems:Int,
                        borderColor: Color= colorResource(R.color.teal_700),
                        showFilterButton:Boolean=false,
                        onFilterClick:()->Unit={},
                        content:@Composable ()->Unit){
    val context = LocalContext.current

    Column(modifier=Modifier.fillMaxSize().padding(5.dp)
        .shadow(elevation = 5.dp,shape=shape)
        .background(color= Color.White, shape = shape)
        .border(width = 1.dp, shape = shape, color = borderColor)
        .padding(5.dp)){
        Row(modifier=Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Label(" $TOTAL_ITEMS_IN_PAGE_LABEL $totalItems")
            if(showFilterButton){
                IconButton(R.drawable.ic_filter_white,
                    background = colorResource(R.color.teal_700), onClick = onFilterClick)

            }
        }
        HorizontalDivider()
        VerticalSpacer()
        Box(modifier=Modifier.fillMaxSize().weight(1f),
            contentAlignment = Alignment.Center){
            content()
        }
        HorizontalDivider()
        VerticalSpacer()
        Row(modifier=Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){

            IconButton(icon=R.drawable.ic_arrow_back_teal, containerSize = 28,onClick = {
                if(currentPage.intValue>1) currentPage.intValue--
            })

            Row(modifier=Modifier.fillMaxWidth().weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){
                HorizontalSpacer()
                if(lastPage<5){
                    for(i in 1..<lastPage){
                        Box(modifier=Modifier.size(36.dp)
                            .background(color = colorResource(if(currentPage.intValue==i) R.color.blue else R.color.black),
                                shape= CircleShape
                            )
                            .clickable { currentPage.intValue=i },
                            contentAlignment = Alignment.Center){
                            Label("$i", color =  whiteColor(context), fontSize = 16 )
                        }
                        HorizontalSpacer()
                    }
                }else{
                    for(i in 1..6){
                        Box(modifier=Modifier.size(36.dp)
                            .background(color = colorResource(if(currentPage.intValue==i) R.color.blue else R.color.black),
                                shape= CircleShape
                            )
                            .clickable { currentPage.intValue=i },
                            contentAlignment = Alignment.Center){
                            Label("$i", color =  whiteColor(context), fontSize = 16 )
                        }
                        HorizontalSpacer()
                    }
                }
                HorizontalSpacer()
            }

            IconButton(icon=R.drawable.ic_arrow_forward_teal, containerSize = 28,onClick = {
                if(currentPage.intValue<lastPage) currentPage.intValue++
            })


        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Container(
    title:String,
              headerAlignment: TextAlign = TextAlign.Center,
              headerColor: Color = Color. Black,
              headerFontSize: Int = 14,
              headerShape: Shape = RectangleShape,
              headerFontWeight: FontWeight = FontWeight. Normal,
              headerShowBackButton:Boolean=false,
              headerIconButtonBackground: Color = Color.White,
              icon:Int= R.drawable.ic_arrow_back_white,
              showSheet: MutableState<Boolean>,
              sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
              sheetContent:@Composable ()->Unit={},
              sheetColor: Color=Color.Red,
              headerOnClick: () -> Unit={},
              sheetOnClick:()->Unit={},
              content:@Composable ()->Unit){
    val context = LocalContext.current

    if (showSheet.value) {
        ModalBottomSheet(
            onDismissRequest = { showSheet.value = false },
            sheetState = sheetState,
            shape = RectangleShape,
            containerColor = sheetColor,
            contentColor = whiteColor(context),
            dragHandle = {}
        ) {
            Column(modifier=Modifier.fillMaxWidth()){
                VerticalSpacer()
                Row(modifier=Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically){
                    IconButton(R.drawable.ic_close_white,
                        background = Color.Transparent) {
                        try { sheetOnClick.invoke() }catch (e:Exception){e.printStackTrace()}
                        showSheet.value=false
                    }
                    Box(modifier=Modifier.fillMaxWidth().weight(1f),
                        contentAlignment = Alignment.CenterEnd){
                        sheetContent() }
                    HorizontalSpacer()
                    Icon(R.drawable.ic_cancel_white, background = Color.Transparent)
                }
                VerticalSpacer()
            }
        }
    }
    Column(modifier= Modifier.background(Color.White)) {
        Header(text = title, textAlign = headerAlignment,
            color=headerColor,
            fontSize = headerFontSize,
            shape = headerShape,
            fontWeight=headerFontWeight,
            showBackButton =  headerShowBackButton,
            iconButtonBackground=headerIconButtonBackground,
            icon = icon,
            onClick = headerOnClick
        )
        ColumnContainer{content()}
    }

}