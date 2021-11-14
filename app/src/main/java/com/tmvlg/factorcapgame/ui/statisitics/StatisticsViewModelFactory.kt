package com.tmvlg.factorcapgame.ui.statisitics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tmvlg.factorcapgame.data.repository.game.GameRepositoryImpl
import com.tmvlg.factorcapgame.data.repository.user.UserRepository
import java.lang.RuntimeException

class StatisticsViewModelFactory(private val userRepository: UserRepository, private val gameRepository: GameRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StatisticsViewModel::class.java))
            return StatisticsViewModel(userRepository, gameRepository) as T
        throw RuntimeException("Unknown view model class $modelClass")
    }
}
