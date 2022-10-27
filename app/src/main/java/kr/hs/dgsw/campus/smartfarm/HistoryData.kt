package kr.hs.dgsw.campus.smartfarm

data class HistoryData(
    val name: String,
    val start: String,
    val end: String,
    val humidity: String,
    val temperature: String,
    val waterLevel : String
)
