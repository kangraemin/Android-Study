package com.lcw.study.clonebaemin.data.search

data class SearchData(
    val restaurants: List<Restaurant>
)

data class Restaurant(
    val full_address: String,
    val id: Int,
    val lat: String,
    val lng: String,
    val name: String
)