package uz.gita.scalegamekids.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import uz.gita.scalegamekids.ui.menu.MenuViewModel
import uz.gita.scalegamekids.navigation.Navigator
import uz.gita.scalegamekids.ui.menu.MenuScreenDirections
import javax.inject.Inject

@HiltViewModel
class MenuViewModelImpl @Inject constructor(
    private val navigator: Navigator
) : MenuViewModel, ViewModel() {
    override val isResume = MutableStateFlow(false)

    override fun start() {
        viewModelScope.launch { navigator.navigateTo(MenuScreenDirections.actionMenuScreenToGameScreen()) }
    }

    override fun resume() {
        TODO("Not yet implemented")
    }

    override fun setting() {
        TODO("Not yet implemented")
    }

    override fun about() {
        TODO("Not yet implemented")
    }

    override fun exit() {
        TODO("Not yet implemented")
    }
}