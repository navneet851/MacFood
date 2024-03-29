package com.android.fastfood.macfood.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor() : ViewModel() {
    init {
        Log.d("checking", "hello guys")
    }
}