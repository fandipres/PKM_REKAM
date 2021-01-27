package com.fandipres.rekam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.user_activity_login.*

class AdminLoginActivity : AppCompatActivity() {
    var db = DataBaseHandler(this)
    var check = true;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_activity_login)

        showHide.setOnClickListener {
            if (showHide.isChecked) {
                kataSandi.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            } else {
                kataSandi.setInputType(129);
            }
        }
    }

    fun masukAkun(view: View) {
        check = true;
        if (!(alamatEmail.text.contains("@") && alamatEmail.text.contains("."))) {
            Toast.makeText(this, "Email tidak valid.", Toast.LENGTH_SHORT).show();
            check = false;
        } else if (kataSandi.text.toString() == "") {
            Toast.makeText(this, "Kata sandi tidak valid.", Toast.LENGTH_SHORT).show();
            check = false;
        }

        if (check == true) {
            var check2 = db.checkUserExist(alamatEmail.text.toString(), kataSandi.text.toString())
            if (check2 == true || alamatEmail.text.toString() == "admin@rekam.com")
                startActivity(Intent(this, AdminMainActivity::class.java))
            else
                Toast.makeText(this, "Email atau kata sandi salah.", Toast.LENGTH_SHORT).show()
        }
    }
}