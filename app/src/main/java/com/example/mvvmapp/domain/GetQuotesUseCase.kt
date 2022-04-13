package com.example.mvvmapp.domain

import com.example.mvvmapp.data.Model.QuoteModel
import com.example.mvvmapp.data.Model.QuoteRepository

class GetQuotesUseCase  {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()


}