package kr.hs.dgsw.campus.smartfarm

import retrofit2.Call
import retrofit2.http.*

interface API {
    @GET("hydro/last/{device-id}")
    fun getData(@Path("device-id") device_id:Int): Call<SensorData>

//    @POST("device/")
//    fun postData(@Body deviceData: DeviceData): Call<>

    @GET("device/{device-id}")
    fun getVegetableData(@Path("device-id") device_id:Int): Call<VegetableData>

//    @GET("hydro/period")
//    fun getSensorData(
//        @Query("periodData") periodData: PeriodData): Call<HistorySensorData>


    @GET("hydro/period/{device-id}")
    fun getSensorData(@Path("device-id") device_id:Int, @Query("end") end: String, @Query("start") start: String): Call<HistorySensorData>
}