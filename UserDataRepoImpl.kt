package am.example.task1.repository

import am.example.task1.model.Data
import am.example.task1.network.UserApi
import android.util.Log

class UserDataRepoImpl(val callResponse : UserApi) : UserDataRepo{

   override suspend fun getUserData() : MutableList<Data> {
        val dataList : MutableList<Data> = mutableListOf()
        //val callResponse = UserRetrofitService.retrofit.create(UserApi::class.java)
        
        try {
            val dataCall = callResponse.getUserData()
            if (dataCall.isSuccessful){
                val data = dataCall.body()?.data
                data?.forEach {
                    dataList.add(
                        Data(
                            it.avatar,
                            it.email,
                            it.firstName,
                            it.id,
                            it.lastName
                        )
                    )
                }
            }
        }catch (e : Exception) {
            Log.e("User data call error","data error")
        }
        return dataList
    }
}