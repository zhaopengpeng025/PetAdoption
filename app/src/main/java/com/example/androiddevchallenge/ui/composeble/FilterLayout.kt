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
package com.example.androiddevchallenge.ui.composeble

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.MainViewModel
import com.example.androiddevchallenge.extensions.percentOffsetX
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.transparent
import com.example.androiddevchallenge.ui.theme.white

@Preview
@Composable
fun FilterLayout() {
    val viewModel: MainViewModel = viewModel()
    val current = viewModel.selectedFilter
    val startOffset by animateFloatAsState(
        when (current) {
            0 -> 0f
            1 -> 1f
            else -> 2f
        }
    )
    Column(modifier = Modifier.background(color = MyTheme.colors.primary)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            FilterItem(
                Modifier
                    .weight(1f)
                    .clickable { viewModel.filterPuppyList(0) },
                "All",
                current == 0
            )
            FilterItem(
                Modifier
                    .weight(1f)
                    .clickable { viewModel.filterPuppyList(1) },
                "Boy",
                current == 1
            )
            FilterItem(
                Modifier
                    .weight(1f)
                    .clickable { viewModel.filterPuppyList(2) },
                "Girl",
                current == 2
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth((1 / 3f))
                .percentOffsetX(startOffset),
            color = MyTheme.colors.filter,
            thickness = 4.dp
        )
    }
}

@Preview
@Composable
fun FilterItem(modifier: Modifier = Modifier, text: String = "", selected: Boolean = false) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = if (selected) MyTheme.colors.selected else transparent),
        contentAlignment = Alignment.Center
    ) {
        Text(
            color = white,
            text = text,
        )
    }
}
