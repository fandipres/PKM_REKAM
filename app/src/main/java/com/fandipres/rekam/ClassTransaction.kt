package com.fandipres.rekam

class ClassTransaction {
    var id: Int = 0
    var id_user: Int = 0
    var id_kamera: Int = 0
    var lama: Int = 0
    var totalbiaya: Int = 0
    var tglmulai: String = ""
    var tglakhir: String = ""

    constructor(
        id_user: Int,
        id_kamera: Int,
        lama: Int,
        totalbiaya: Int,
        tglmulai: String,
        tglakhir: String
    ) {
        this.id_user = id_user
        this.id_kamera = id_kamera
        this.lama = lama
        this.totalbiaya = totalbiaya
        this.tglmulai = tglmulai
        this.tglakhir = tglakhir
    }

    constructor() {
    }
}