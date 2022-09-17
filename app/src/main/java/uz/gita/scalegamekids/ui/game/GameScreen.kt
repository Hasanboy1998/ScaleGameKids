package uz.gita.scalegamekids.ui.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.scalegamekids.R
import uz.gita.scalegamekids.WinDialogFragment
import uz.gita.scalegamekids.databinding.ScreenGameBinding
import kotlin.math.abs

@AndroidEntryPoint
class GameScreen : Fragment(R.layout.screen_game) {
    private val viewBinding: ScreenGameBinding by viewBinding(ScreenGameBinding::bind)
    private var fX = 0f
    private var fY = 0f
    private var oldX = 0f
    private var oldY = 0f
    private var count = 0
    private var win = false

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.dum.setOnTouchListener { v, event ->
            touch(v as ImageView, viewBinding.dumTarget, event)
            true
        }
        viewBinding.chapShoq.setOnTouchListener { v, event ->
            touch(v as ImageView, viewBinding.chapShoqTarget, event)
            true
        }
        viewBinding.ongShoq.setOnTouchListener { v, event ->
            touch(v as ImageView, viewBinding.ongShoqTarget, event)
            true
        }
        viewBinding.bosh.setOnTouchListener { v, event ->
            touch(v as ImageView, viewBinding.boshTarget, event)
            true
        }
        viewBinding.gavda.setOnTouchListener { v, event ->
            touch(v as ImageView, viewBinding.gavdaTarget, event)
            true
        }
        viewBinding.chapOldi.setOnTouchListener { v, event ->
            touch(v as ImageView, viewBinding.chapOldiTarget, event)
            true
        }
        viewBinding.chapOrqa.setOnTouchListener { v, event ->
            touch(v as ImageView, viewBinding.chapOrqaTarget, event)
            true
        }
        viewBinding.ongOldi.setOnTouchListener { v, event ->
            touch(v as ImageView, viewBinding.ongOldiTarget, event)
            true
        }
        viewBinding.ongOrqa.setOnTouchListener { v, event ->
            touch(v as ImageView, viewBinding.ongOrqaTarget, event)
            true
        }
    }

    private fun touch(image: ImageView, target: ImageView, event: MotionEvent) {
        val a = image.translationZ


        Log.d("DDD", a.toString())
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                image.translationZ = 2f
                fX = event.x
                fY = event.y
                oldX = image.x
                oldY = image.y

                if (count == 9) {
                    viewBinding.imgForegraund.visibility = View.INVISIBLE
                    viewBinding.target.visibility = View.VISIBLE
                }
            }
            MotionEvent.ACTION_MOVE -> {
                val dX = event.x - fX
                val dY = event.y - fY
                image.x += dX
                image.y += dY
            }
            MotionEvent.ACTION_UP -> {
                image.translationZ = 0f
                val tX = target.x
                val tY = target.y
                val oX = image.x
                val oY = image.y
                if (abs(tX - oX) < 50 && abs(tY - oY) < 50) {
                    image.x = tX
                    image.y = tY
                    count++
                } else {
                    image.x = oldX
                    image.y = oldY
                }

                if (count == 9) {
                    viewBinding.imgForegraund.visibility = View.VISIBLE
                    viewBinding.target.visibility = View.INVISIBLE
                    win = true
                } else {
                    viewBinding.imgForegraund.visibility = View.INVISIBLE
                    viewBinding.target.visibility = View.VISIBLE
                }
                if (win) {
                    win = false
                    WinDialogFragment().showNow(this.parentFragmentManager, "dialog")
                }
            }
        }
    }
}