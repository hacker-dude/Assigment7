package com.example.assigment7.patterns

import com.google.gson.annotations.SerializedName


data class SingleJson(
    @SerializedName("data") var data: Data? = Data(),
    @SerializedName("support") var support: Support? = Support()
)