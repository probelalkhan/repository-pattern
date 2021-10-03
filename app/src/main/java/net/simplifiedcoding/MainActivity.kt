package net.simplifiedcoding

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import net.simplifiedcoding.data.network.Resource
import net.simplifiedcoding.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private val viewModel: MainViewModel by viewModels()
  private val adapter = UsersAdapter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.recyclerView.adapter = adapter

    viewModel.users.observe(this) { resource ->
      //@Todo handle other cases as well
      if (resource is Resource.Success) {
        adapter.submitList(resource.value)
      }
    }
  }

}