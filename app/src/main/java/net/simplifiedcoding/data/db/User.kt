package net.simplifiedcoding.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
  val avatar: String,
  val email: String,
  val first_name: String,
  val last_name: String
) {
  @PrimaryKey(autoGenerate = true)
  var id: Int = 0
}