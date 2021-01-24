package com.devdossantos.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
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
        Scaffold(topBar = {FormTopBar()}) {
            
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

    @Preview
    @Composable
    private fun DefaultPreview() {
        FormContent()
    }
}