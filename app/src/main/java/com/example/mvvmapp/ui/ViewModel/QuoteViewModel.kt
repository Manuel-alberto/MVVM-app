package com.example.mvvmapp.ui.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapp.data.Model.QuoteModel
import com.example.mvvmapp.data.Model.QuoteProvider
import com.example.mvvmapp.domain.GetQuotesUseCase
import com.example.mvvmapp.domain.GetRandomQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    val quoteModel=MutableLiveData<QuoteModel>()
    val isLoading=MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuotesUseCase = GetRandomQuotesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun ramdomQuote(){
        isLoading.postValue(true)

        val quote = getRandomQuotesUseCase()
        if (quote!=null){
            quoteModel.postValue(quote!!)
        }

        isLoading.postValue(false)
    }

}