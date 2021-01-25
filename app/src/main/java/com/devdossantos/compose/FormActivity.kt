package com.devdossantos.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData

class FormActivity : AppCompatActivity() {

    private val _addUserState = MutableLiveData(AddUserState())

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
        val nameState = remember { mutableStateOf("") }
        val emailState = remember { mutableStateOf("") }
        val roles = resources.getStringArray(R.array.roles)


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            OutlinedTextField(value = nameState.value,
                onValueChange = {
                    nameState.value = it
                    _addUserState.value = _addUserState.value?.copy(name = it)
                },
                label = { Text(text = stringResource(id = R.string.name_hint)) })

            OutlinedTextField(value = emailState.value,
                onValueChange = {
                    emailState.value = it
                    _addUserState.value = _addUserState.value?.copy(email = it)
                },
                label = { Text(text = stringResource(id = R.string.email_hint)) })

            DropdownMenu(
                toggle = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = stringResource(id = R.string.role_select))
                        }

                    }
                }, expanded = false, onDismissRequest = { /*TODO*/ }) {

                DropdownMenuItem(onClick = { /*TODO*/ }) {

                }
            }

            Button(onClick = { onAddTapade() }) {
                Text(text = stringResource(id = R.string.add_button_text))
            }
        }
    }

    private fun onAddTapade() {
        val userState = _addUserState.value?: return
        Log.d("USER_STATE", "$userState")
    }

    @Composable
    private fun DefaultPreview() {
        FormContent()
    }
}