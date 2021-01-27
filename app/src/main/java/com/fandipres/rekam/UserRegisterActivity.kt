package com.fandipres.rekam

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.user_activity_register.*
import kotlinx.android.synthetic.main.user_activity_register.alamatEmail
import kotlinx.android.synthetic.main.user_activity_register.kataSandi

class UserRegisterActivity : AppCompatActivity() {
    var db = DataBaseHandler(this)
    var user = ClassUser()
    var check = true;
    var check2 = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity_register)

        alamatEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                check2 = db.checkUserEmail(alamatEmail.text.toString())
                if (check2 == true) {
                    alamatEmail2.setText("Alamat email sudah terdaftar.");
                } else {
                    alamatEmail2.setText(null);
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        kataSandi.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (kataSandi.text.toString() != kataSandi2.text.toString()) {
                    kataSandi3.setText("Kedua password tidak sesuai.");
                    check = false;
                } else {
                    kataSandi3.setText(null);
                    check = true;
                }
            }
        })

        kataSandi2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (kataSandi.text.toString() != kataSandi2.text.toString()) {
                    kataSandi3.setText("Kedua password tidak sesuai.");
                    check = false;
                } else {
                    kataSandi3.setText(null);
                    check = true;
                }
            }
        })

        showHide.setOnClickListener {
            if (showHide.isChecked) {
                kataSandi.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                kataSandi2.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            } else {
                kataSandi.setInputType(129);
                kataSandi2.setInputType(129);
            }
        }
    }

    fun buatAkun(view: View) {
        check = true;
        if (namaLengkap.text.toString() == "") {
            Toast.makeText(this, "Nama tidak valid.", Toast.LENGTH_SHORT).show();
            check = false;
        } else if (!(alamatEmail.text.contains("@") && alamatEmail.text.contains("."))) {
            Toast.makeText(this, "Email tidak valid.", Toast.LENGTH_SHORT).show();
            check = false;
        } else if ((kataSandi.text.toString() == "" || kataSandi2.text.toString() == "") || (kataSandi.text.toString() != kataSandi2.text.toString())) {
            Toast.makeText(this, "Kata sandi tidak valid.", Toast.LENGTH_SHORT).show();
            check = false;
        } else if (nomorHandphone.text.toString() == "") {
            Toast.makeText(this, "Nomor telepon tidak valid.", Toast.LENGTH_SHORT).show();
            check = false;
        }

        if (check == true && check2 == false) {
            user = ClassUser(
                namaLengkap.text.toString(),
                alamatEmail.text.toString(),
                kataSandi.text.toString(),
                nomorHandphone.text.toString()
            )
            db.addUser(user);

            var dialog = AlertDialog.Builder(this)
                .setTitle("Pendaftaran Berhasil")
                .setMessage("Silahkan klik OK untuk melanjutkan.")
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                    startActivity(Intent(this, UserLoginActivity::class.java))
                });
            dialog.show();
        }
    }
}