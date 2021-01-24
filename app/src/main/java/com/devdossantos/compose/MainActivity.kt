package com.devdossantos.compose

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }

    }

    @Composable
    private fun MainContent() {
        Scaffold(
            topBar = { MainTopBar() },
            floatingActionButton = { MainFav() }
        ) {

        }
    }

    @Composable
    private fun MainTopBar() {
        TopAppBar(
            title = { Text(stringResource(id = R.string.app_name)) },
            backgroundColor = colorResource(id = R.color.purple_500),
            contentColor = Color.White
        )
    }

    @Composable
    private fun MainFav() {
        FloatingActionButton(onClick = {
            showAddForm()
        }) {
            Icon(imageVector = Icons.Filled.Add)
        }
    }

    private fun showAddForm() {
        startActivity(Intent(this, FormActivity::class.java))
    }
}

