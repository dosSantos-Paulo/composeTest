package com.devdossantos.compose

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource


class MainActivity : AppCompatActivity() {
    private val reponseState = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK){
            val response = data?.getParcelableExtra<AddUserState>("USER_STATE")
            reponseState.value = response.toString()
        }
    }

    @Composable
    private fun MainContent() {
        Scaffold(
            topBar = { MainTopBar() },
            floatingActionButton = { MainFav() }
        ) {

            Text(text = reponseState.value)
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
        startActivityForResult(Intent(this, FormActivity::class.java), 100)
    }
}

