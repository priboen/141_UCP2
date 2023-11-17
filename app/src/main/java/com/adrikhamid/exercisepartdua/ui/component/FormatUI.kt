package com.adrikhamid.exercisepartdua.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adrikhamid.exercisepartdua.R

@Composable
fun DataMahasiswa(
    namaMHS: String,
    nimMHS: String,
    konsenMHS:String,
){
    Text(
        text = stringResource(R.string.namaMhs)
    )
    Text(namaMHS)
    Divider()
    Spacer(modifier = Modifier.padding(8.dp))

    Text(
        text = stringResource(R.string.nimMhs)
    )
    Text(nimMHS)
    Divider()
    Spacer(modifier = Modifier.padding(8.dp))

    Text(
        text = stringResource(R.string.konsenMhs),
    )
    Text(konsenMHS)
    Divider()
}