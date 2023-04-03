package com.rohan.areader.data.remote.book_data

data class MBook(
    var id: String? = null,
    var title: String? = null,
    var authors: String? = null,
    val notes: String
)
