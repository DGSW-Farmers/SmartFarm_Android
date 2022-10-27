package kr.hs.dgsw.campus.smartfarm

data class SensorData(
    val humidity: String,
    val led: String,
    val liquid: String,
    val pan: String,
    val pump: String,
    val sunlight: String,
    val temperature: String,
    val waterLevel: String
)
