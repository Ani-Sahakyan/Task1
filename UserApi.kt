package am.example.task1.network

import am.example.task1.model.UserData
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("api/users?page=2")
    suspend fun getUserData() : Response<UserData>
}