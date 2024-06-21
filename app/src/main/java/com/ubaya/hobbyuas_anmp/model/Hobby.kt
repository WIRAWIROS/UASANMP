package com.ubaya.hobbyuas_anmp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hobby(
    @ColumnInfo(name="judul")
    var judul:String,
    @ColumnInfo(name="deskripsi")
    var deskripsi:String,
    @ColumnInfo(name="category")
    var category:String,
    @ColumnInfo(name="pengarang")
    var pengarang:Int,
) {
    @PrimaryKey(autoGenerate = true)
    var uuid:Int =0
}