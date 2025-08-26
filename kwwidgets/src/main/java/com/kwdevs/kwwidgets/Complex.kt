package com.kwdevs.kwwidgets

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.kwdevs.kwwidgets.buttons.CustomButton
import com.kwdevs.kwwidgets.buttons.IconButton
import java.time.Instant
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun Header(text:String,
           textAlign: TextAlign = TextAlign. Center,
           color: Color = Color. Black,
           fontSize: Int = 14,
           hasHeader:Boolean=true,
           shape: Shape = RectangleShape,
           fontWeight: FontWeight = FontWeight. Normal,
           showBackButton:Boolean=false,
           iconButtonBackground: Color = Color.White,
           icon: Int=R.drawable.ic_arrow_back_white,
           onClick: () -> Unit={}){
    if(hasHeader){
        Box(modifier= Modifier.fillMaxWidth().clip(shape),
            contentAlignment = Alignment.CenterEnd){
            Row(modifier= Modifier.fillMaxWidth(),
                horizontalArrangement =  Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically){
                Label(text=text,textAlign=textAlign,color=color,fontSize=fontSize,fontWeight=fontWeight)
            }
            if(showBackButton){
                IconButton(background = iconButtonBackground,icon=icon, onClick = onClick, paddingStart = 5, paddingEnd = 5)
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerWidget(
    showDialog: MutableState<Boolean>, datePickerState: DatePickerState, timeString: MutableState<String>){
    val context = LocalContext.current

    if(showDialog.value){
        Dialog(onDismissRequest = {showDialog.value=false},
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            ColumnContainer{
                Row(modifier=Modifier.fillMaxWidth().padding(5.dp),
                    horizontalArrangement = Arrangement.End){
                    IconButton(icon = R.drawable.ic_cancel_red) {showDialog.value=false }
                }
                LazyColumn {
                    item{
                        Row(modifier=Modifier.fillMaxWidth().padding(5.dp),
                            horizontalArrangement = Arrangement.Center){
                            CustomButton(label = SAVE_CHANGES_LABEL
                                , buttonShape = RectangleShape, enabledBackgroundColor = greenColor(context),
                            ){
                                timeString.value = getFormattedDateJavaTime(datePickerState)
                                showDialog.value=false
                            }
                        }
                        DatePicker(state = datePickerState)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateTimePickerWidget(
    showDialog: MutableState<Boolean>,
    datePickerState: DatePickerState,
    timeString: MutableState<String>
) {
    val context = LocalContext.current
    val selectedHour = remember { mutableStateOf(LocalTime.now().hour) }
    val selectedMinute = remember { mutableStateOf(LocalTime.now().minute) }
    val showTimePicker = remember { mutableStateOf(false) }

    if (showDialog.value) {
        Dialog(
            onDismissRequest = { showDialog.value = false },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            ColumnContainer{
                Row(
                    modifier = Modifier.fillMaxWidth().padding(5.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(icon = R.drawable.ic_cancel_red) {
                        showDialog.value = false
                        showTimePicker.value=false
                    }
                }

                LazyColumn {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(5.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CustomButton(
                                label = PICL_TIME_LABEL,
                                buttonShape = RectangleShape,
                                enabledBackgroundColor = Color.Gray
                            ) {
                                showTimePicker.value = true
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth().padding(5.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CustomButton(
                                label = SAVE_CHANGES_LABEL,
                                buttonShape = RectangleShape,
                                enabledBackgroundColor = greenColor(context)
                            ) {
                                val millis = datePickerState.selectedDateMillis
                                if (millis != null) {
                                    val date = Instant.ofEpochMilli(millis)
                                        .atZone(ZoneId.systemDefault())
                                        .toLocalDate()

                                    val time = LocalTime.of(
                                        selectedHour.value,
                                        selectedMinute.value
                                    )

                                    val dateTime = LocalDateTime.of(date, time)
                                    timeString.value = dateTime.format(
                                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
                                    )
                                } else {
                                    timeString.value = "No date selected"
                                }
                                showDialog.value = false
                            }
                        }

                        DatePicker(state = datePickerState)
                    }
                }
            }
        }
    }

    if (showTimePicker.value) {
        TimePickerDialog(
            context,
            { _, hour: Int, minute: Int ->
                selectedHour.value = hour
                selectedMinute.value = minute
                showTimePicker.value = false
            },
            selectedHour.value,
            selectedMinute.value,
            true
        ).show()
    }
}
