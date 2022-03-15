package com.wojnar.bookt.controller

import com.wojnar.bookt.model.BookUser
import com.wojnar.bookt.service.BookUserService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class BookUserController (
    private val bookUserService: BookUserService
    ){

    @GetMapping("/bookUser/{id}")
    public fun getBookUser(@PathVariable("id") id: String): Mono<BookUser> {
        return bookUserService.getBookUser(id)
    }

    @GetMapping("/bookUsers")
    public fun getBookUsers(): Flux<BookUser> {
        return bookUserService.getBookUsers()
    }

    @PostMapping("/bookUser/save")
    public fun addBookUser(@RequestBody bookUser: BookUser): Mono<BookUser> {
        return bookUserService.addBookUser(bookUser)
    }

    @PatchMapping("/bookUser/{bookUserId}/borrow/{bookId}")
    public fun borrowBookForBookUser(@PathVariable("bookUserId") bookUserId: String, @PathVariable("bookId") bookId: String): Mono<BookUser> {
        return bookUserService.borrowBookForBookUser(bookUserId, bookId)
    }

    @PatchMapping("/bookUser/{bookUserId}/return/{bookId}")
    public fun returnBookForBookUser(@PathVariable("bookUserId") bookUserId: String, @PathVariable("bookId") bookId: String): Mono<BookUser> {
        return bookUserService.returnBookForBookUser(bookUserId, bookId)
    }

    @GetMapping("/bookUser/book/{bookId}")
    public fun getBookUsersForBorrowedBook(@PathVariable("bookId") bookId: String): Flux<BookUser> {
        return bookUserService.getBookUsersForBorrowedBook(bookId)
    }
}