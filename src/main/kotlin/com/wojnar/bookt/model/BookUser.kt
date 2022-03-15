package com.wojnar.bookt.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class BookUser (
    @Id
    val id: String,
    val name: String,
    val surname: String,
    val borrowedBooks: MutableList<String> = arrayListOf(),
    val pastBorrowedBooks: MutableList<String> = arrayListOf()

    ) {
    public fun borrowBook(bookId: String) {
        borrowedBooks.add(bookId)
    }

    public fun returnBook(bookId: String) {
        borrowedBooks.remove(bookId)
        pastBorrowedBooks.add(bookId)
    }
}
