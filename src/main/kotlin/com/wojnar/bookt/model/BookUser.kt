package com.wojnar.bookt.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class BookUser (
    @Id
    val id: String,
    val name: String,
    val surname: String,
    val borrowedBooks: List<String>,
    val pastBorrowedBooks: List<String>

    )
