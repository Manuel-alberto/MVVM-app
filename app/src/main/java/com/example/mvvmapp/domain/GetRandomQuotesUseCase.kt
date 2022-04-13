package com.example.mvvmapp.domain

import com.example.mvvmapp.data.Model.QuoteModel
import com.example.mvvmapp.data.Model.QuoteProvider
import com.example.mvvmapp.data.Model.QuoteRepository

class GetRandomQuotesUseCase {

    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            var randomNumber=(0..quotes.size -1).random()
            return quotes[randomNumber]
        }
        return null
    }

}