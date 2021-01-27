package com.fandipres.rekam

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.user_activity_payment.*
import java.util.*

class UserPaymentActivity : AppCompatActivity() {
    val Bulan =
        arrayOf(
            "Januari",
            "Februari",
            "Maret",
            "April",
            "Mei",
            "Juni",
            "Juli",
            "Agustus",
            "September",
            "Oktober",
            "November",
            "Desember"
        )
    var tglSewa: Int = 0
    var tglSewa2: Int = 0
    var lamaSewa: Int = 0
    var check = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity_payment)

        val adapterPembayaran = ArrayAdapter.createFromResource(
            this,
            R.array.media_pembayaran,
            android.R.layout.simple_spinner_dropdown_item
        )
        spinnerPembayaran.adapter = adapterPembayaran;
        spinnerPembayaran.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val adapterPengiriman = ArrayAdapter.createFromResource(
            this,
            R.array.media_pengiriman,
            android.R.layout.simple_spinner_dropdown_item
        )
        spinnerPengiriman.adapter = adapterPengiriman;
        spinnerPengiriman.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    fun dateMulai(view: View) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in textbox
                txtMulai.setText("" + dayOfMonth + " " + Bulan[monthOfYear] + " " + year)
                tglSewa = dayOfMonth
                if(tglSewa > tglSewa2){
                    lamaSewa = tglSewa - tglSewa2
                }
                else
                    lamaSewa = tglSewa2 - tglSewa

                totalBiaya.text = "Rp. " + (150000 * lamaSewa).toString()
            },
            year,
            month,
            day
        )
        dpd.show()
    }

    fun dateAkhir(view: View) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in textbox
                txtAkhir.setText("" + dayOfMonth + " " + Bulan[monthOfYear] + " " + year)
                tglSewa2 = dayOfMonth
                if(tglSewa > tglSewa2){
                    lamaSewa = tglSewa - tglSewa2
                }
                else
                    lamaSewa = tglSewa2 - tglSewa

                totalBiaya.text = "Rp. " + (150000 * lamaSewa).toString()
            },
            year,
            month,
            day
        )
        dpd.show()
    }

    fun prosesPenyewaan(view: View) {
        check = true;
        if(lamaSewa > 7){
            check = false
            Toast.makeText(this, "Maksimum durasi perentalan adalah 7 hari.", Toast.LENGTH_SHORT).show();
        }
        else if(txtMulai.text.toString() == "" || txtAkhir.text.toString() == ""){
            check = false
            Toast.makeText(this, "Harap pilih waktu perentalan.", Toast.LENGTH_SHORT).show();
        }

        if(check == true){
            var dialog = AlertDialog.Builder(this)
                .setTitle("Pembayaran Berhasil")
                .setMessage("Mohon menunggu, produk sedang dipersiapkan.")
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                    startActivity(Intent(this, UserOrderActivity::class.java))
                });
            dialog.show();
        }
    }
}