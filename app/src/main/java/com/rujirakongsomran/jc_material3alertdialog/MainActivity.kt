package com.rujirakongsomran.jc_material3alertdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rujirakongsomran.jc_material3alertdialog.ui.theme.JC_Material3AlertDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_Material3AlertDialogTheme {
                CreateDialog()
            }
        }
    }
}

@Composable
fun CreateDialog() {
    val openDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { openDialog.value = true },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Show Dialog")
        }
    }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            icon = {
                Icon(Icons.Filled.Lock, contentDescription = null)
            },
            title = {
                Text(text = "Dialog with lock icon")
            },
            text = {
                Text(
                    "This area typically contains the supportive text " +
                            "which presents the details regarding the Dialog's purpose."
                )

            },
            confirmButton = {
                TextButton(
                    onClick = { openDialog.value = false },

                    ) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { openDialog.value = false },
                ) {
                    Text(text = "Dismiss")
                }
            }
        )
    }

}

@Preview
@Composable
fun CreateDialogPreview() {
    JC_Material3AlertDialogTheme {
        CreateDialog()
    }
}