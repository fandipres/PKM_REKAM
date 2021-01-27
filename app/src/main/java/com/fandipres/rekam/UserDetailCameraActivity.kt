package com.fandipres.rekam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class UserDetailCameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity_detail_camera)
    }

    fun pembayaranSewa(view: View) {
        startActivity(Intent(this, UserPaymentActivity::class.java))
    }
}