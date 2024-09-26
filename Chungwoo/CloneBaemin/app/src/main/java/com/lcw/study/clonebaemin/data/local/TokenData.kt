package com.lcw.study.clonebaemin.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TOKEN")
data class TokenData(
    @ColumnInfo(name = "refresh")
    val refresh: String?,
    @ColumnInfo(name = "access")
    val access: String?,

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
