package com.adrikhamid.exercisepartdua

import androidx.lifecycle.ViewModel
import com.adrikhamid.exercisepartdua.data.DosenUIState
import com.adrikhamid.exercisepartdua.data.MahasiswaUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(MahasiswaUIState())
    private val _dosenstateUI = MutableStateFlow(DosenUIState())
    val stateUI: StateFlow<MahasiswaUIState> = _stateUI.asStateFlow()
    val dosenstateUI: StateFlow<DosenUIState> = _dosenstateUI.asStateFlow()


    fun setNama(list: MutableList<String>){
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(
            nama = list[0],
            nim = list[1],
            konsentrasi = list[2]
        )
        }
    }
    fun setDosen(dosenPilihan: String) {
        _dosenstateUI.update { stateSaatIni -> stateSaatIni.copy(dosbing1 = dosenPilihan) }

    }
    fun setDosen1(dosenPilihan1: String) {
        _dosenstateUI.update { stateSaatIni -> stateSaatIni.copy(dosbing2 = dosenPilihan1) }

    }
}