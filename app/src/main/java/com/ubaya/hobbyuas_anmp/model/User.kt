package com.ubaya.hobbyuas_anmp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @ColumnInfo(name="nama")
    var nama:String,
    @ColumnInfo(name="username")
    var username:String,
    @ColumnInfo(name="email")
    var email:String,
    @ColumnInfo(name="password")
    var password:Int,
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}