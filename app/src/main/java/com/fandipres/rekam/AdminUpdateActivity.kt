package com.fandipres.rekam

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.admin_activity_add.*
import kotlinx.android.synthetic.main.admin_activity_update.*

class AdminUpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_activity_update)

    }

    fun searchKamera(view: View) {
        if (idKamera.text.toString() == "")
            Toast.makeText(this, "ID Kamera tidak valid.", Toast.LENGTH_SHORT).show()
    }

    fun updateKamera(view: View) {
        if (idKamera.text.toString() == "")
            Toast.makeText(this, "ID Kamera tidak valid.", Toast.LENGTH_SHORT).show()
        else {
            var MyLayout = layoutInflater.inflate(R.layout.admin_activity_update_camera, null)
            var myDialogBuilder = AlertDialog.Builder(this).apply {
                setView(MyLayout)
                setTitle("Update Camera")
            }
            var myDialog = myDialogBuilder.create()
            var NamaKamera = MyLayout.findViewById<EditText>(R.id.namaKamera)
            var TipeKamera = MyLayout.findViewById<Spinner>(R.id.spinnerTipe)
            var HargaKamera = MyLayout.findViewById<EditText>(R.id.hargaKamera)
            var Deskripsi = MyLayout.findViewById<EditText>(R.id.deskripsiKamera)
            var btnUpdate = MyLayout.findViewById<Button>(R.id.btnUpdate)
            btnUpdate.setOnClickListener {
                Toast.makeText(this, "Kamera berhasil diperbaharui.", Toast.LENGTH_SHORT).show()
                myDialog.cancel()
            }
            myDialog.show()
        }
    }

    fun deleteKamera(view: View) {
        if (idKamera.text.toString() == "")
            Toast.makeText(this, "ID Kamera tidak valid.", Toast.LENGTH_SHORT).show()
        else {
            lateinit var dialog: AlertDialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Apakah Kamu Yakin?")
            builder.setMessage("Harap berhati-hati karena tindakan penghapusan tidak dapat dibatalkan.")
            val dialogClickListener = DialogInterface.OnClickListener { _, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        Toast.makeText(
                            this,
                            "Kamera berhasil dihapus.",
                            Toast.LENGTH_SHORT
                        ).show()
                        idKamera.text.clear()
                    }
                    DialogInterface.BUTTON_NEGATIVE -> this
                }
            }
            builder.setPositiveButton("YES", dialogClickListener)
            builder.setNegativeButton("NO", dialogClickListener)
            dialog = builder.create()
            dialog.show()
        }
    }
}