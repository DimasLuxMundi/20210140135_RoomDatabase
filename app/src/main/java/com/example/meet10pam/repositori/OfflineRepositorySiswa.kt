package com.example.meet10pam.repositori

import com.example.meet10pam.data.Siswa
import com.example.meet10pam.data.SiswaDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositorySiswa(private val siswaDao: SiswaDao) : RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> {
        return siswaDao.getAllSiswa()
    }

    override fun getSiswaStream(id: Int): Flow<Siswa?> {
        return siswaDao.getSiswa(id)
    }

    override suspend fun insertSiswa(siswa: Siswa) {
        return siswaDao.insert(siswa)
    }

    override suspend fun deleteSiswa(siswa: Siswa) {
        return siswaDao.delete(siswa)
    }

    override suspend fun updateSiswa(siswa: Siswa) {
        return siswaDao.update(siswa)
    }
}