package com.wojnar.bookt.service

import com.wojnar.bookt.model.Book
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BookService {
    fun addBook(book: Book): Mono<Book>
    fun getBook(id: String): Mono<Book>
    fun getBooks(): Flux<Book>

}
