/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.composeble.AdoptionDetail
import com.example.androiddevchallenge.ui.composeble.FilterLayout
import com.example.androiddevchallenge.ui.composeble.PuppyList
import com.example.androiddevchallenge.ui.composeble.WelcomePage
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.white

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }

    override fun onBackPressed() {
        val viewModel: MainViewModel by viewModels()
        if (viewModel.selectedAdoption != null) {
            viewModel.dismissAdoptionDetail()
        } else {
            super.onBackPressed()
        }
    }
}

@Composable
fun MyApp() {
    val viewModel: MainViewModel = viewModel()
    MyTheme (theme = viewModel.theme){
        Box {
            Column {
                TopBar()
                FilterLayout()
                PuppyList(adoptionList = viewModel.currentAdoptionList)
            }
            WelcomePage()
            if (viewModel.selectedAdoption != null) {
                AdoptionDetail(adoptionInfo = viewModel.selectedAdoption!!)
            }
        }
    }
}


@Preview
@Composable
fun TopBar() {
    Row(
        Modifier
            .background(color = MyTheme.colors.primary)
            .height(55.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = "Puppy list",
            color = white,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 50.dp)
        )
        val viewModel: MainViewModel = viewModel()
        Column() {
            Icon(
                painterResource(R.drawable.ic_palette),
                "Switch Theme",
                Modifier
                    .padding(start = 200.dp)
                    .clickable(onClick = {
                        viewModel.theme = when (viewModel.theme) {
                            MyTheme.Theme.Light -> MyTheme.Theme.Dark
                            MyTheme.Theme.Dark -> MyTheme.Theme.Light
                        }
                    }),
                tint = white
            )
        }
    }
}

