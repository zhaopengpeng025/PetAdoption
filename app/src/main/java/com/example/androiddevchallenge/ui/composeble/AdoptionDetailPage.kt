package com.example.androiddevchallenge.ui.composeble

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.TopBar
import com.example.androiddevchallenge.data.AdoptionInfo
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.color_primary_text
import com.example.androiddevchallenge.ui.theme.grey2
import com.example.androiddevchallenge.ui.theme.white

@Composable
fun AdoptionDetail(adoptionInfo: AdoptionInfo) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = white)
            .verticalScroll(
                rememberScrollState(0),
            )
            .fillMaxWidth()) {
        TopBar()
        Image(
            painter = painterResource(id = adoptionInfo.puppy.picture),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        val puppy = adoptionInfo.puppy
        Divider(color = grey2, thickness = 10.dp)
        val storyLabel = "${puppy.name}'s story"
        BlockInfo(label = storyLabel, content = puppy.story)
        Divider(color = grey2, thickness = 10.dp)
        BlockInfo(label = "Adopt Condition", content = adoptionInfo.condition)
        Divider(color = grey2, thickness = 10.dp)
        val contact = adoptionInfo.contact
        val contactInfo = "Name:${contact.name}\nMobile:${contact.mobile}\nEmail:${contact.email}"
        BlockInfo(label = "Contact Information", content = contactInfo)

        Button(
            modifier = Modifier.padding(top = 50.dp,bottom = 50.dp),
            colors = ButtonDefaults.buttonColors(
                MyTheme.colors.accent,
                MyTheme.colors.welcomeText
            ),
            onClick = {

            }) {
            Text(
                text = "Adopt now",
            )
        }
    }

}

@Composable
fun BlockInfo(label: String, content: String) {
    Column(Modifier.padding(20.dp).fillMaxWidth()) {
        Row {
            Divider(
                Modifier.width(4.dp),
                thickness = 25.dp,
                color = MyTheme.colors.primary
            )
            Text(
                text = label,
                Modifier.padding(start = 10.dp),
                color = MyTheme.colors.primary,
                fontSize = 20.sp
            )
        }
        Text(
            modifier = Modifier.padding(top = 15.dp, start = 20.dp),
            text = content, fontSize = 15.sp,
            color = color_primary_text
        )
    }
}

@Preview
@Composable
private fun previewBlockInfo() {
    BlockInfo(
        "Adopt Condition",
        "Usu ex sonet nonumes nominavi, graeci dictas accusam usu ex, te vis prima cotidieque. Cibo mediocrem cu usu, eos probo singulis ad. Accumsan necessitatibus his ea, ad quo suas natum contentiones,"
    )
}