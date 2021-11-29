package com.tmvlg.factorcapgame.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tmvlg.factorcapgame.data.repository.firebase.FirebaseLobbyRepository
import com.tmvlg.factorcapgame.data.repository.user.UserRepository

class MenuViewModelFactory(
    private val userRepository: UserRepository,
    private val firebaseLobbyRepository: FirebaseLobbyRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MenuViewModel::class.java)) {
            return MenuViewModel(userRepository, firebaseLobbyRepository) as T
        }
        throw IllegalArgumentException("Unknown view model class $modelClass")
    }
}