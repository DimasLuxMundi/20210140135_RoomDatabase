package com.example.meet10pam.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.meet10pam.AplikasiSiswa

object PenyediaViewModel {
    val Factory =  viewModelFactory {
        initializer {
            HomeViewModel(AplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            EntryViewModel(AplikasiSiswa().container.repositoriSiswa)
        }
        initializer {
            DetailsViewModel(
                createSavedStateHandle(),
                AplikasiSiswa().container.repositoriSiswa,
            )
        }
        initializer {
            EditViewModel(createSavedStateHandle(), AplikasiSiswa().container.repositoriSiswa)
        }
    }
}

/*
Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah instance dari
[AplikasiSiswa]
 */
fun CreationExtras.AplikasiSiswa():AplikasiSiswa = (this
        [ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)