package com.fandipres.rekam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.admin_activity_list_camera.*

class AdminListCameraActivity : AppCompatActivity() {
    var db = DataBaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_activity_list_camera)

        var data = db.readAllCamera()
        listKamera.text = ""
        for (i in 0..(data.size - 1)) {
            listKamera.append(
                "ID : " + data.get(i).id.toString() + "\nPRODUK : " + data.get(i).nama + "\nTIPE : " + data.get(
                    i
                ).tipe + "\nHARGA : " + data.get(i).biaya + "\nDESC : " + data.get(i).deskripsi + "\n\n"
            )
        }
    }
}