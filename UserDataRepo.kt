package am.example.task1.repository

import am.example.task1.model.Data

interface UserDataRepo {
    suspend fun getUserData(): MutableList<Data>
}