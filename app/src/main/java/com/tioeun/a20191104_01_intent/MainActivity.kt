package com.tioeun.a20191104_01_intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_user_info.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var REQ_DATE_FOR_NAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameInputBtn.setOnClickListener {
            var intent = Intent(this, EditUserInfoActivity::class.java)

//            if(nameEdt.text.toString() != "이름 입력 필요"){
//                intent.putExtra("userName", nameEdt.text.toString())
//            }

            startActivityForResult(intent, REQ_DATE_FOR_NAME)
        }

        phoneInputBtn.setOnClickListener {
            var intent = Intent(this, EditPhoneAcitivity::class.java)
            startActivityForResult(intent, REQ_DATE_FOR_NAME)
        }

        phoneDialBtn.setOnClickListener {
            var uri = Uri.parse("tel:01000000000") // 띄어쓰기하면 안됨.
            var intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        phoneCallBtn.setOnClickListener {
//            var uri = Uri.parse("tel:01000000000")
//            var intent = Intent(Intent.ACTION_CALL, uri)
//            startActivity(intent)
        }

        smsBtn.setOnClickListener {
            var uri = Uri.parse("smsto:01000000000") // 띄어쓰기하면 안됨.
            var intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "우리가 만든 앱입니다.")
            startActivity(intent)
        }
        webLinkBtn.setOnClickListener {
            var uri = Uri.parse("http://naver.com")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        storeLinkBtn.setOnClickListener {
            var uri = Uri.parse("market://details?id=com.kakao.talk")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        googleMapBtn.setOnClickListener {
            var uri = Uri.parse("geo:37.123, 127.567") // 위도, 경도값 대입
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_DATE_FOR_NAME){
            if(resultCode == Activity.RESULT_OK){
                var inputNameData = data?.getStringExtra("inputName")?.toLowerCase()
                inputNameData?.let {
                    nameTxt.text=it
                }
                var inputPhoneData = data?.getStringExtra("inputPhone")?.toLowerCase()
                inputPhoneData?.let {
                    phoneTxt.text = it
                }
            }
        }
    }





}
