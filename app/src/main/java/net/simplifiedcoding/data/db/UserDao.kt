package net.simplifiedcoding.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun addUsers(users: List<User>)

  @Query("SELECT * FROM users")
  fun getUsers(): Flow<List<User>>
}
