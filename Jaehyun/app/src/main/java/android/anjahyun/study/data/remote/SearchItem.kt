package android.anjahyun.study.data.remote

data class SearchItem (
    val restaurants: List<Restaurant>
)
data class Restaurant (
    val id: Int,
    val name: String,
    val lat: String,
    val lng: String,
    val full_address: String
)