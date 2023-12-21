package com.example.newschallenge.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor() : ViewModel() {
    fun getUserInformation() {
        _userInformation.value = UserData()
    }

    private var _userInformation = MutableStateFlow<UserData?>(null)
    val userInformation: StateFlow<UserData?> = _userInformation

    data class UserData(
        val userId: Int = 0,
        val name: String = "Nicolas Laurenti",
        val userName: String = "nicolaurenti",
        val imageUrl: String = "https://picsum.photos/200",
        val location: Pair<Double, Double> = Pair(-24.77904395877881, -65.41147653076119),
    )
}
