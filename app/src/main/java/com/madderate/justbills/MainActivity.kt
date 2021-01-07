package com.madderate.justbills

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.math.MathUtils
import com.madderate.justbills.databinding.ActivityMainBinding
import com.madderate.justbills.utilx.logD
import com.madderate.justbills.utilx.toast
import com.madderate.justbills.views.fragments.AddNewBillFragment

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val bottomSheetBehavior by lazy {
        BottomSheetBehavior.from(mainBinding.nav).apply {
            state = BottomSheetBehavior.STATE_HIDDEN
            addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

                override fun onStateChanged(bottomSheet: View, newState: Int) {}

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    "slideOffset: $slideOffset".logD(TAG)
                    if (slideOffset > -1f) {
                        val baseColor = Color.BLACK
                        val baseAlpha =
                            ResourcesCompat.getFloat(resources, R.dimen.material_emphasis_medium)
                        val offset = (slideOffset + 1f) / 2f
                        val alpha = MathUtils.lerp(0f, 255f, offset * baseAlpha).toInt()
                        val color =
                            Color.argb(alpha, baseColor.red, baseColor.green, baseColor.blue)
                        mainBinding.scrim.setBackgroundColor(color)
                    }
                }

            })
        }
    }

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        initView()
    }

    private fun initView() {
        initFragments()
        initBottomAppBar()
        initNavigationView()
    }

    private fun initFragments() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, AddNewBillFragment.newInstance())
            .commit()
    }

    private fun initBottomAppBar() {
        mainBinding.bottomAppBar.run {
            setNavigationOnClickListener {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                setScrimClickListener()
            }

            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.cancel -> {
                        toast("保存取消")
                        true
                    }
                    R.id.save -> {
                        toast("保存成功")
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        }
    }

    private fun setScrimClickListener() {
        mainBinding.scrim.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            removeScrimClickListener()
        }
    }

    private fun removeScrimClickListener() {
        mainBinding.scrim.setOnClickListener(null)
    }

    private fun initNavigationView() {
        mainBinding.nav.run {
            setNavigationItemSelectedListener {
                it.isChecked = true
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
                true
            }
        }
    }
}