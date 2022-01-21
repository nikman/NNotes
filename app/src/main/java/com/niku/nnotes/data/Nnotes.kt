package com.niku.nnotes.data

//@Entity
data class Nnotes (
    //@PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var title: String = "",
    var content: String = ""
)