package com.fandipres.rekam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AdminMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_activity_main)
    }

    fun listKamera(view: View) {
        startActivity(Intent(this, AdminListCameraActivity::class.java))
    }

    fun addKamera(view: View) {
        startActivity(Intent(this, AdminAddActivity::class.java))
    }

    fun updateKamera(view: View) {
        startActivity(Intent(this, AdminUpdateActivity::class.java))
    }

    fun listTransaksi(view: View) {
        startActivity(Intent(this, AdminListTransactionActivity::class.java))
    }

    fun logOut(view: View) {
        startActivity(Intent(this, UserWelcomeActivity::class.java))
    }
}