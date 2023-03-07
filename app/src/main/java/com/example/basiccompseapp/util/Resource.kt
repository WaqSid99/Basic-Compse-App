package com.example.basiccompseapp.util


// Sealed class that contains the states the the api request can contain
sealed class Resource <T> (val data: T? = null, val message: String? = null){

    class Loading<T>() : Resource<T>()

    class Error<T>(message: String?) : Resource<T>(message = message)

    class Success<T>(data: T?) : Resource<T>(data = data)

}
