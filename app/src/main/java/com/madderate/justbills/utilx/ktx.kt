package com.madderate.justbills.utilx

import android.content.Context
import android.util.Log
import android.widget.Toast

/**
 * @author      madderate
 * @date        1/4/21 2:20 PM
 * @description
 */

fun Context.toast(res: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, res, duration).show()
}

fun Context.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

fun String.logD(TAG: String = "JustBills") {
    Log.d(TAG, this)
}

fun String.logE(TAG: String = "JustBills") {
    Log.e(TAG, this)
}