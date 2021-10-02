package net.simplifiedcoding.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun addUsers(users: List<User>)

  @Query("SELECT * FROM users")
  suspend fun getUsers(): List<User>
}
