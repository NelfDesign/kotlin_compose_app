package com.example.kotlincomposefirstapp.randomUser.repositories

import com.example.kotlincomposefirstapp.randomUser.api_service.RetrofitInstance
import com.example.kotlincomposefirstapp.randomUser.models.APIResults

class Repository {
    suspend fun getUserList() : APIResults {
        return RetrofitInstance.api.getRandomUsers()
    }
}