package com.adrikhamid.exercisepartdua

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomePage(
    onNextClickedButton:() -> Unit
){
    val logoScreen = painterResource(id = R.drawable.logo)
    Column(
        modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = logoScreen, contentDescription = null, contentScale = ContentScale.FillHeight)
        Spacer(modifier = Modifier.padding(35.dp))
        Button(onClick = {onNextClickedButton}) {
            Text(stringResource(id = R.string.btn_next))
        }
    }
}

@Preview (showBackground = true)
@Composable
fun showHomepage(){
    HomePage{}
}