package am.example.task1.viewModel

import am.example.task1.model.Data
import am.example.task1.repository.UserDataRepo
import am.example.task1.repository.UserDataRepoImpl
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserDataViewModel(val userRepoImpl : UserDataRepo) : ViewModel() {
    //private val userRepo : UserDataRepo
    private val _userData by lazy { MutableLiveData<MutableList<Data>>() }
    val userData : LiveData<MutableList<Data>> = _userData

    /*init {
      userRepo = UserDataRepo()
    }*/

    fun getData(){
      viewModelScope.launch {
          _userData.postValue(userRepoImpl.getUserData())
      }
    }
}


