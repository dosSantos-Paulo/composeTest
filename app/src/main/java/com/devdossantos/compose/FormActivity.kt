package com.devdossantos.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FormContent()
        }
    }

    @Composable
    private fun FormContent() {
        Scaffold(topBar = { FormTopBar() }) {
            FormFields()
        }
    }

    @Composable
    private fun FormTopBar() {
        TopAppBar(
            title = { Text(stringResource(id = R.string.add_title)) },
            navigationIcon = {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(imageVector = Icons.Default.ArrowBack)
                }
            },
            backgroundColor = colorResource(id = R.color.purple_500),
            contentColor = Color.White
        )
    }

    @Composable
    private fun FormFields() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            OutlinedTextField(value = "",
                onValueChange = {},
                label = { Text(text = stringResource(id = R.string.name_hint)) })

            OutlinedTextField(value = "",
                onValueChange = {},
                label = { Text(text = stringResource(id = R.string.email_hint)) })

            DropdownMenu(
                toggle = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = stringResource(id = R.string.role_select))
                        }

                        Text(text = "Desconhecido")
                    }
                }, expanded = false, onDismissRequest = { /*TODO*/ }) {

                DropdownMenuItem(onClick = { /*TODO*/ }) {

                }
            }

            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.add_button_text))
            }
        }
    }

    @Preview
    @Composable
    private fun DefaultPreview() {
        FormContent()
    }
}