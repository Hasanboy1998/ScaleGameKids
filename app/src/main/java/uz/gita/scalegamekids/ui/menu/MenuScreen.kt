package uz.gita.scalegamekids.ui.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.ldralighieri.corbind.view.clicks
import uz.gita.scalegamekids.R
import uz.gita.scalegamekids.databinding.ScreenMenuBinding

@AndroidEntryPoint
class MenuScreen : Fragment(R.layout.screen_menu) {
    private val viewBinding: ScreenMenuBinding by viewBinding(ScreenMenuBinding::bind)
    private val viewModel: MenuViewModel by viewModels<MenuViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.btnStart.clicks()
            .onEach { viewModel.start() }
            .launchIn(lifecycleScope)
    }
}