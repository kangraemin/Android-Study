package android.anjahyun.study.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "SearchInfo")
data class Search(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date") val date: String
) {
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int = 0
}