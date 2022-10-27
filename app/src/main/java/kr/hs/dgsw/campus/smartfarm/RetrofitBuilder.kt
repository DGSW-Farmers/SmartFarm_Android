package kr.hs.dgsw.campus.smartfarm


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val okHttpClient = OkHttpClient.Builder().build()
    var api: API
    private var serverIP: String = "61.97.187.175:8080/smartfarm/"

    init {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://" + serverIP)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(API::class.java)
    }
}