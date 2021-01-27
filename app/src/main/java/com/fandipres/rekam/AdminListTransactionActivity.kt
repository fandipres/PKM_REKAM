package com.fandipres.rekam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.admin_activity_list_transaction.*

class AdminListTransactionActivity : AppCompatActivity() {
    var db = DataBaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_activity_list_transaction)

//        var data = db.readAllTransaksi()
//        listTransaksi.text = ""
//        for (i in 0..(data.size - 1)) {
//            listTransaksi.append(
//                "ID : " + data.get(i).id.toString() + "\nID USER : " + data.get(i).id_user + "\nID KAMERA : " + data.get(
//                    i
//                ).id_kamera + "\nTOTAL BIAYA : " + data.get(i).totalbiaya + "\nDURASI (HARI) : " + data.get(i).lama + "\nTANGGAL RENTAL : " + data.get(
//                    i
//                ).tglmulai + " - " + data.get(i).tglakhir + "\n\n"
//            )
//        }
    }
}