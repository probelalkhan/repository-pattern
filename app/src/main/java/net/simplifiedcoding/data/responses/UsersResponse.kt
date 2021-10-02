package net.simplifiedcoding.data.responses

import net.simplifiedcoding.data.db.User

data class UsersResponse(
  val `data`: List<User>,
  val page: Int,
  val per_page: Int,
  val total: Int,
  val total_pages: Int
)