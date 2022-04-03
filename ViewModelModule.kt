package am.example.task1.aa

import am.example.task1.viewModel.UserDataViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { UserDataViewModel(userRepoImpl = get()) }
}