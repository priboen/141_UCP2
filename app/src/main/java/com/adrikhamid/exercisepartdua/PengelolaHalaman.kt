package com.adrikhamid.exercisepartdua

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adrikhamid.exercisepartdua.data.DataDosbing.dosen

enum class PengelolaHalaman {
    Home,
    Form,
    Output
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ucpApp(
    ViewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
    ) { innerPadding ->
        val uiState by ViewModel.stateUI.collectAsState()
        val uidosenState by ViewModel.dosenstateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PengelolaHalaman.Home.name) {
                HomePage(onNextClickedButton = {
                    navController.navigate(PengelolaHalaman.Form.name)
                })
            }
            
            composable(route=PengelolaHalaman.Form.name){
                val context = LocalContext.current
                FormPage(
                    pilihanDosen = dosen.map { id -> context.resources.getString(id) },
                    pilihanDosen1 = dosen.map { id -> context.resources.getString(id) },
                    onSelectionChanged = {
                        ViewModel.setDosen(it)},
                    onSelectionChanged1 = {ViewModel.setDosen1(it)},
                    onSubmitButtonClicked = {
                        ViewModel.setNama(it)
                        navController.navigate(PengelolaHalaman.Output.name)
                    }
                )
            }
            
            composable(route = PengelolaHalaman.Output.name){
                Datapage(
                    mahasiswaUIState = uiState,
                    dosenUIState = uidosenState,
                    onCancelButtonClicked = {navController.popBackStack(PengelolaHalaman.Form.name, false)})
            }


        }
    }
}