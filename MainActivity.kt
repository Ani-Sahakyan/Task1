package am.example.task1

import am.example.task1.databinding.ActivityMainBinding
import am.example.task1.viewModel.UserDataViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity()  {
    lateinit var binding: ActivityMainBinding
    val userDataViewModel : UserDataViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerAdapter = UserAdapter(mutableListOf())
        binding.userDataRecycler.run {
            adapter = recyclerAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

       // val userDataViewModel = ViewModelProvider(this).get(UserDataViewModel::class.java)
        userDataViewModel.getData()
        userDataViewModel.userData.observe(this, Observer {
            recyclerAdapter.update(it)
        })
    }
}

