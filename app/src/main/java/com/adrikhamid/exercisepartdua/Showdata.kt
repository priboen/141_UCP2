package com.adrikhamid.exercisepartdua

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrikhamid.exercisepartdua.data.DosenUIState
import com.adrikhamid.exercisepartdua.data.MahasiswaUIState
import com.adrikhamid.exercisepartdua.ui.component.DataMahasiswa

@Composable
fun Datapage(
    mahasiswaUIState: MahasiswaUIState,
    dosenUIState: DosenUIState,
    onCancelButtonClicked: () -> Unit
){
    val items = listOf(
        Pair(stringResource(id = R.string.title_dosen1), dosenUIState.dosbing1),
        Pair(stringResource(id = R.string.title_dosen2), dosenUIState.dosbing2)
    )

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DataMahasiswa(
                namaMHS = mahasiswaUIState.nama,
                nimMHS = mahasiswaUIState.nim,
                konsenMHS = mahasiswaUIState.konsentrasi
            )
            Spacer(modifier = Modifier.padding(8.dp))
            items.forEach { item ->
                Column {
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(thickness = 1.dp)
            }
            Spacer(modifier = Modifier.padding(8.dp))
        }
        Row(
            modifier = Modifier
                .weight(1f, false)
                .padding(8.dp)
        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Button(modifier = Modifier.fillMaxWidth(),onClick = onCancelButtonClicked) {
                    Text(stringResource(R.string.btn_back))
                }
            }
        }
    }
}