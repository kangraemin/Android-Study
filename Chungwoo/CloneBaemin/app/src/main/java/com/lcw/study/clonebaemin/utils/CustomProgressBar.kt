package com.lcw.study.clonebaemin.utils

import android.app.Dialog
import android.content.Context
import android.view.View
import com.lcw.study.clonebaemin.R

class CustomProgressBar(context: Context) : Dialog(context) {
    override fun setContentView(view: View) {
        setContentView(R.layout.dialog_progress)

    }

}