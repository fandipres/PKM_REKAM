package com.fandipres.rekam

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.user_activity_register.alamatEmail

class UserRecoveryActivity : AppCompatActivity() {
    var db = DataBaseHandler(this)
    var check = true;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity_recovery)
    }

    fun resetPassword(view: View) {
        check = true;
        if (!(alamatEmail.text.contains("@") && alamatEmail.text.contains("."))) {
            Toast.makeText(this, "Email tidak valid.", Toast.LENGTH_SHORT).show();
            check = false;
        }

        if (check == true) {
            var check2 = db.checkUserEmail(alamatEmail.text.toString())

            if (check2 == true) {
                var dialog = AlertDialog.Builder(this)
                        .setTitle("Reset Password")
                        .setMessage("Silahkan cek email kamu untuk melakukan reset password.")
                        .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                            startActivity(Intent(this, UserLoginActivity::class.java))
                        });
                dialog.show();
            } else
                Toast.makeText(this, "Akun tidak ditemukan.", Toast.LENGTH_SHORT).show()
        }
    }
}