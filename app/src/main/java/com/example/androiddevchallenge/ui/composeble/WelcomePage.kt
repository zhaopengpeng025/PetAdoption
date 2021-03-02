package com.example.androiddevchallenge.ui.composeble

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.MainViewModel
import com.example.androiddevchallenge.extensions.percentOffsetX
import com.example.androiddevchallenge.ui.theme.MyTheme


@Composable
fun WelcomePage() {
    val viewModel: MainViewModel = viewModel()
    val startOffset by animateFloatAsState(
        if (viewModel.startNow ) {
            -1f
        } else {
            0f
        }
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .percentOffsetX(startOffset)
            .background(color = MyTheme.colors.welcomeBg),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Puppy Adoption",
            Modifier.padding(top = 200.dp),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = MyTheme.colors.welcomeText
        )

        Button(
            modifier = Modifier.padding(top = 50.dp),
            colors = ButtonDefaults.buttonColors(
                MyTheme.colors.accent,
                MyTheme.colors.welcomeText
            ),
            onClick = {
                viewModel.startNow = true
            }) {
            Text(
                text = "Pick now",
            )
        }
    }
}