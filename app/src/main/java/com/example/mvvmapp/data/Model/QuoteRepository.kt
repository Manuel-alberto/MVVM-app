package com.example.mvvmapp.data.Model

import com.example.mvvmapp.data.Model.network.QuoteService

class QuoteRepository {

    private val api= QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response=api.getQuotes()
        QuoteProvider.quotes=response
        return response
    }

}