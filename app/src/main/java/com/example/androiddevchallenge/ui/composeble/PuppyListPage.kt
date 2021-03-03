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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.MainViewModel
import com.example.androiddevchallenge.data.AdoptionInfo
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.color_primary_text
import com.example.androiddevchallenge.ui.theme.color_secondary_text
import com.example.androiddevchallenge.ui.theme.divider_color

@Composable
fun PuppyItem(adoptionInfo: AdoptionInfo) {
    val puppy = adoptionInfo.puppy
    val viewModel: MainViewModel = viewModel()
    Row(
        Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clickable {
                viewModel.showAdoptionDetail(adoptionInfo)
            }
    ) {
        val puppyInfo = "${puppy.name},${puppy.gender},${puppy.age}"
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = puppy.picture),
            contentDescription = puppyInfo,
            contentScale = ContentScale.Crop
        )

        Column(Modifier.padding(start = 10.dp, bottom = 10.dp)) {
            Text(
                text = puppyInfo,
                color = color_primary_text,
                fontSize = 18.sp,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = puppy.story,
                color = color_secondary_text,
                fontSize = 15.sp,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun PuppyList(adoptionList: List<AdoptionInfo>) {
    LazyColumn(Modifier.background(color = MyTheme.colors.itemBg)) {
        itemsIndexed(adoptionList) { index, item ->
            PuppyItem(item)
            if (index < adoptionList.size - 1) {
                Divider(color = divider_color)
            }
        }
    }
}
