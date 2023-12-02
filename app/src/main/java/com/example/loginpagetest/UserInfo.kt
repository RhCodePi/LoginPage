package com.example.loginpagetest



class UserInfo(
    private var userId : Int,
    private var userName: String,
    private var userEmail: String,
    private var userPassword: String
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



}