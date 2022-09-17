package uz.gita.scalegamekids.ui.menu

import kotlinx.coroutines.flow.Flow

interface MenuViewModel {
    val isResume: Flow<Boolean>

    fun start()
    fun resume()
    fun setting()
    fun about()
    fun exit()
}