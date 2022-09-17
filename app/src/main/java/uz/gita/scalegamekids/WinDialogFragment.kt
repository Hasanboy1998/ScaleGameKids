package uz.gita.scalegamekids

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.scalegamekids.databinding.DialogWinBinding

class WinDialogFragment : DialogFragment(R.layout.dialog_win) {
    private val binding: DialogWinBinding by viewBinding(DialogWinBinding::bind)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnMenu.setOnClickListener {
            findNavController().navigateUp()
            dismissNow()
        }
//        requireActivity().window.setBackgroundDrawableResource(R.color.trans)
        showsDialog = true
    }
}