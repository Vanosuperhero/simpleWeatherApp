package com.example.simpleweatherapp.utils

import retrofit2.Response

const val BODY_IS_NULL = "Body is null"

abstract class BaseApiResponse {

    suspend fun <T> apiSafeCall(call: suspend () -> Response<T>): Result<T> {
        return try {
            val response = call()
            if (response.isSuccessful){
                response.body()?.let { body ->
                    Result.Success(body)
                } ?: Result.Error(data = null, message = BODY_IS_NULL)
            }
            else
                Result.Error(data = null, message = response.message().toString())
        } catch (e: Exception) {
            Result.Error(data = null, message = e.message.toString())
        }
    }
}