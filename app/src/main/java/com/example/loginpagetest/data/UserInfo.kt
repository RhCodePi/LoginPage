package com.example.loginpagetest.data

class UserInfo(
    private val userId : Int,
    private var userName: String,
    private var userEmail: String,
    private var userPassword: String,
    private val userDetail: UserDetail
) {

    fun getUserId() : Int
    {
        return userId
    }
    fun getUserName(): String {
        return userName
    }

    fun getUserEmail(): String {
        return userEmail
    }
    fun getUserPassword(): String {
        return userPassword
    }

    fun getUserDetail(): UserDetail{
        return userDetail
    }
}