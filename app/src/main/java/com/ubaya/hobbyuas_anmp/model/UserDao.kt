package com.ubaya.hobbyuas_anmp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg user: User)

    @Query("select * from user where uuid= :id")
    fun selectUser(id: Int): User

    @Delete
    fun deleteUser(todo: User)

    @Query("UPDATE user SET nama=:nama, username=:username, email=:email, password=:password WHERE uuid = :id")
    fun update(nama: String, username: String, email: String,password: Int, id: Int)

    //cara dosen pendek update
    @Update
    fun updateUser(user: User)
    //
}