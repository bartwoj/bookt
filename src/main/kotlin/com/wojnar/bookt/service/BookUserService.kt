package com.wojnar.bookt.service

import com.wojnar.bookt.model.BookUser
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BookUserService {
    fun getBookUser(id: String): Mono<BookUser>
    fun getBookUsers(): Flux<BookUser>
    fun addBookUser(bookUser: BookUser): Mono<BookUser>
    fun borrowBookForBookUser(bookUserId: String, bookId: String): Mono<BookUser>

    fun returnBookForBookUser(bookUserId: String, bookId: String): Mono<BookUser>
    fun getBookUsersForBorrowedBook(bookId: String): Flux<BookUser>
}
