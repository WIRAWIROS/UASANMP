package com.ubaya.hobbyuas_anmp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface HobbyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg hobby: Hobby)

    @Query("select * from hobby ORDER BY pengarang DESC")
    fun selectAllHobby(): List<Hobby>

    @Query("select * from hobby where uuid= :id")
    fun selectHobby(id: Int): Hobby

    @Delete
    fun deleteTodo(todo: Hobby)

    @Query("UPDATE hobby SET judul=:judul, deskripsi=:deskripsi, category=:category, pengarang=:pengarang WHERE uuid = :id")
    fun update(judul: String, deskripsi: String, category: String,pengarang: Int, id: Int)

    //cara dosen pendek update
    @Update
    fun updateHobby(hobby: Hobby)
    //
}
