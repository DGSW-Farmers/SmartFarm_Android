package kr.hs.dgsw.campus.smartfarm

import retrofit2.Call
import retrofit2.http.*

interface API {
    @GET("hydro/last/{device-id}")
    fun getData(@Path("device-id") device_id:Int): Call<SensorData>
}