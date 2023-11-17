@file:OptIn(ExperimentalMaterial3Api::class)

package com.adrikhamid.exercisepartdua

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPage(
    pilihanDosen: List<String>,
    pilihanDosen1: List<String>,
    onSelectionChanged: (String) -> Unit,
    onSelectionChanged1: (String) -> Unit,

    onSubmitButtonClicked: (MutableList<String>) -> Unit,
){

    var namaMahasiswa by remember {
        mutableStateOf("")
    }
    var nimMahasiswa by remember {
        mutableStateOf("")
    }
    var konsenMahasiswa by remember {
        mutableStateOf("")
    }

    var judulSkripsi by remember {
        mutableStateOf("")
    }

    var pilihanDosbing1 by remember {
        mutableStateOf("")
    }
    var pilihanDosbing2 by remember {
        mutableStateOf("")
    }

    var listDosen: MutableList<String> = mutableListOf(namaMahasiswa, nimMahasiswa, konsenMahasiswa)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(id = R.string.app_title), fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Spacer(modifier = Modifier.padding(10.dp))
        Column {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = namaMahasiswa,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.namaMhs)) },
                onValueChange = {namaMahasiswa = it}
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = nimMahasiswa,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.nimMhs)) },
                onValueChange = {nimMahasiswa = it}
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = konsenMahasiswa,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.konsenMhs)) },
                onValueChange = {konsenMahasiswa = it}
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = judulSkripsi,
                shape = MaterialTheme.shapes.large,
                label = { Text(text = stringResource(id = R.string.skripsiMhs)) },
                onValueChange = { judulSkripsi = it }
            )
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Column(
                modifier = Modifier.padding(5.dp)
            ){
                Text(stringResource(id = R.string.title_dosen1))
                pilihanDosen.forEach { item ->
                    Row (
                        modifier = Modifier.selectable(
                            selected = pilihanDosbing1 == item,
                            onClick = {
                                pilihanDosbing1 = item
                                onSelectionChanged(item)
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(selected = pilihanDosbing1 == item, onClick = {
                            pilihanDosbing1 = item
                            onSelectionChanged(item)
                        }
                        )
                        Text(item)
                    }
                }
                
            }
            Column (
                modifier = Modifier.padding(5.dp)
            ){
                Text(stringResource(id = R.string.title_dosen2))
                pilihanDosen1.forEach { item ->
                    Row (
                        modifier = Modifier.selectable(
                            selected = pilihanDosbing2 == item,
                            onClick = {
                                pilihanDosbing2 = item
                                onSelectionChanged1(item)
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(selected = pilihanDosbing2 == item, onClick = {
                            pilihanDosbing2 = item
                            onSelectionChanged1(item)
                        }
                        )
                        Text(item)
                    }
                }
                
            }
        }
        Button(onClick = { onSubmitButtonClicked(listDosen) }) {
            Text(stringResource(id = R.string.btn_submit))
        }

    }

}
