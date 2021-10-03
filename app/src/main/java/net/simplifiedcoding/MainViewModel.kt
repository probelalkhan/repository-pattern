package net.simplifiedcoding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import net.simplifiedcoding.data.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
  repo: UserRepository
) : ViewModel() {
  val users = repo.getUsers().asLiveData()
}