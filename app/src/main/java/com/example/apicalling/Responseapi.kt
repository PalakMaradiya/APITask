package com.example.apicalling

import com.google.gson.annotations.SerializedName

data class Responseapi(

	@field:SerializedName("Responseapi")
	val responseapi: List<ResponseapiItem?>? = null
)

data class ResponseapiItem(

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
