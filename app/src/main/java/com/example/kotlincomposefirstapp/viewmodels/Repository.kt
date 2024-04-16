package com.example.kotlincomposefirstapp.viewmodels

import com.example.kotlincomposefirstapp.api_service.RetrofitInstance
import com.example.kotlincomposefirstapp.models.APIResults

class Repository {
    suspend fun getUserList() : APIResults {
        return RetrofitInstance.api.getRandomUsers()
    }
}