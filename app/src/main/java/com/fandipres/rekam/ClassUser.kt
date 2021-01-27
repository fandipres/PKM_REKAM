package com.fandipres.rekam

class ClassUser {
    var id: Int = 0
    var nama: String = ""
    var email: String = ""
    var password: String = ""
    var handphone: String = ""

    constructor(nama: String, email: String, password: String, handphone: String) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.handphone = handphone;
    }

    constructor(email: String, password: String) {
        this.email = email;
        this.password = password;
    }

    constructor(email: String) {
        this.email = email;
    }

    constructor() {
    }
}