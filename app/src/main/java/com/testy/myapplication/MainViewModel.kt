package com.testy.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel :ViewModel(){

    private val _tickFlow = MutableSharedFlow<Int>(replay = 0)
    val tickFlow: SharedFlow<Int> = _tickFlow

    init {

    }

}