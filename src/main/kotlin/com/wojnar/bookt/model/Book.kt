package com.wojnar.bookt.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Book (
    @Id
    val id: String,
    val title: String,
    val author: String
)