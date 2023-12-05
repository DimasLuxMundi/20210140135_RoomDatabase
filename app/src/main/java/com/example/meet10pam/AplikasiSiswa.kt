package com.example.meet10pam

import android.app.Application
import com.example.meet10pam.repositori.ContainerApp
import com.example.meet10pam.repositori.ContainerDataApp

class AplikasiSiswa: Application() {
    /*
    AppContainer instance digunakan oleh kelas-kelas lainnya untuk mendapatkan dependensi
     */
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }


}