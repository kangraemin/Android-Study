package com.lcw.study.clonebaemin.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import io.reactivex.Completable

@Dao
interface TokenDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) //같은데이터 충돌시 무시
    fun insert(token: TokenData): Completable
}