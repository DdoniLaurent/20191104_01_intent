package com.tioeun.a20191104_01_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_phone_acitivity.*
import kotlinx.android.synthetic.main.activity_edit_user_info.*
import kotlinx.android.synthetic.main.activity_edit_user_info.cancelBtn
import kotlinx.android.synthetic.main.activity_edit_user_info.okBtn

class EditPhoneAcitivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone_acitivity)

        okBtn.setOnClickListener {
            var intent = Intent()
            intent.putExtra("inputPhone", phoneEdt.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        cancelBtn.setOnClickListener {
            finish()
        }
    }
}
