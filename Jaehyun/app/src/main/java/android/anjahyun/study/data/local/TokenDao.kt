package android.anjahyun.study.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface TokenDao {
    @Query(value = "SELECT * FROM UserInfo LIMIT 1")
    fun getToken(): Single<Token>

    @Insert
    fun insertToken(item: Token): Completable

    @Query(value = "DELETE FROM UserInfo")
    fun deleteToken(): Completable
}