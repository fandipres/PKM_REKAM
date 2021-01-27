package com.fandipres.rekam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class UserWelcomeActivity : AppCompatActivity() {
    var db = DataBaseHandler(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity_welcome)
    }

    fun buatAkun(view: View) {
        startActivity(Intent(this, UserRegisterActivity::class.java))
    }

    fun masukAkun(view: View) {
        //db.deleteDatabase()
        startActivity(Intent(this, UserLoginActivity::class.java))
    }
}