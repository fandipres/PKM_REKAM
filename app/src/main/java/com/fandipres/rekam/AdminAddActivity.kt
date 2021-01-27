package com.fandipres.rekam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.admin_activity_add.*

class AdminAddActivity : AppCompatActivity() {
    var db = DataBaseHandler(this)
    var kamera = ClassCamera()
    var tipeKamera: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_activity_add)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.tipe_kamera,
            android.R.layout.simple_spinner_dropdown_item
        )
        spinnerTipe.adapter = adapter;
        spinnerTipe.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p0 != null)
                    tipeKamera = p0.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    fun addKamera(view: View) {
        if (namaKamera.text.toString() == "" || hargaKamera.text.toString() == "" || deskripsiKamera.text.toString() == "")
            Toast.makeText(this, "Harap isi semua bidang yang tersedia.", Toast.LENGTH_SHORT).show()
        else if(hargaKamera.text.contains("."))
        else {
            kamera = ClassCamera(
                namaKamera.text.toString(),
                tipeKamera,
                hargaKamera.text.toString().toInt(),
                deskripsiKamera.text.toString()
            )
            db.addKamera(kamera)

            namaKamera.text.clear()
            hargaKamera.text.clear()
            deskripsiKamera.text.clear()
        }
    }
}