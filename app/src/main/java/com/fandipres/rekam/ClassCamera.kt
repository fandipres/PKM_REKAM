package com.fandipres.rekam

data class DataCamera(var dataNama: String, var dataTipe: String, var dataBiaya: String, var dataGambar: Int)

class ClassCamera {
    var id: Int = 0;
    var nama: String = ""
    var tipe: String = ""
    var biaya: Int = 0
    var deskripsi: String = ""
    var gambar: Byte = 0

    constructor(nama: String, tipe: String, biaya: Int, deskripsi: String, gambar: Byte = 0) {
        this.nama = nama;
        this.tipe = tipe
        this.biaya = biaya
        this.deskripsi = deskripsi
        this.gambar = gambar
    }

    constructor() {
    }
}