package am.example.task1.aa

import am.example.task1.repository.UserDataRepo
import am.example.task1.repository.UserDataRepoImpl
import org.koin.dsl.module

val repoModule = module {
    single<UserDataRepo> { UserDataRepoImpl(callResponse = get()) }
}