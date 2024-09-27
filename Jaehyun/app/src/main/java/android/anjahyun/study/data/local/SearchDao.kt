package android.anjahyun.study.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface SearchDao {
    @Query(value = "SELECT * FROM SearchInfo")
    fun getSearchList(): Single<List<Search>>

    @Insert
    fun insertSearch(item: Search): Completable

    @Query(value = "DELETE FROM SearchInfo")
    fun deleteSearch(): Completable
}