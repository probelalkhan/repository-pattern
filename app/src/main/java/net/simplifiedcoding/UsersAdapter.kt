package net.simplifiedcoding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import net.simplifiedcoding.data.db.User
import net.simplifiedcoding.databinding.ItemUserBinding

class UsersAdapter :
  ListAdapter<User, UsersAdapter.RestaurantViewHolder>(UserComparator()) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
    val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return RestaurantViewHolder(binding)
  }

  override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
    val currentItem = getItem(position)
    if (currentItem != null) {
      holder.bind(currentItem)
    }
  }

  class RestaurantViewHolder(private val binding: ItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User) {
      binding.imageView.loadImageFromUrl(user.avatar)
      binding.textViewName.text = user.fullName
      binding.textViewEmail.text = user.email
    }
  }

  class UserComparator : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User) =
      oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: User, newItem: User) =
      oldItem == newItem
  }
}