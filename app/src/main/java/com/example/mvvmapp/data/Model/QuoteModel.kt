package com.example.mvvmapp.data.Model

import com.google.gson.annotations.SerializedName

data class QuoteModel(@SerializedName("quote") val quote:String, @SerializedName("author")val author:String)
