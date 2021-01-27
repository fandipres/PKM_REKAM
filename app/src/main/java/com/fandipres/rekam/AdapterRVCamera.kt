package com.fandipres.rekam

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRVCamera(data: MutableList<DataCamera>) :
    RecyclerView.Adapter<AdapterRVCamera.MyHolder>() {
    private var RVData = data;

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                itemView.context.startActivity(
                    Intent(
                        itemView.context,
                        UserDetailCameraActivity::class.java
                    )
                )
            }
        }

        var Gambar = itemView.findViewById<ImageView>(R.id.dataGambar)
        var Nama = itemView.findViewById<TextView>(R.id.dataNama)
        var Tipe = itemView.findViewById<TextView>(R.id.dataTipe)
        var Biaya = itemView.findViewById<TextView>(R.id.dataBiaya)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRVCamera.MyHolder {
        var inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_list_camera, parent, false)
        return MyHolder(inflate)
    }

    override fun onBindViewHolder(holder: AdapterRVCamera.MyHolder, position: Int) {
        holder.Gambar.setImageResource(RVData.get(position).dataGambar)
        holder.Nama.setText(RVData.get(position).dataNama)
        holder.Tipe.setText(RVData.get(position).dataTipe)
        holder.Biaya.setText(RVData.get(position).dataBiaya)
    }

    override fun getItemCount(): Int = RVData.size
}