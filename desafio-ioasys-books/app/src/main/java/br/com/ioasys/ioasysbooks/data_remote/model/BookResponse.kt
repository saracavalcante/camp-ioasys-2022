package br.com.ioasys.ioasysbooks.data_remote.model

import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("id")
    val id: String?,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("authors")
    val author: List<String>?,
    @SerializedName("pageCount")
    val pages: String? = "",
    @SerializedName("category")
    val category: String? = "",
    @SerializedName("imageUrl")
    val imageUrl: String = "",
    @SerializedName("publisher")
    val editor: String? = "",
    @SerializedName("published")
    val date: String? = "",
    @SerializedName("isbn10")
    val isbn10: String? = "",
    @SerializedName("isbn13")
    val isbn13: String? = "",
    @SerializedName("language")
    val language: String? = "",
    @SerializedName("description")
    val description: String? = "",
)