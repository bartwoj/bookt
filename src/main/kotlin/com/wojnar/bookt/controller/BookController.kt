package com.wojnar.bookt.controller

import com.wojnar.bookt.model.Book
import com.wojnar.bookt.service.BookService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class BookController(
    private val bookService: BookService,
    ) {

    @PostMapping("/book/save")
    public fun addBook(@RequestBody book: Book): Mono<Book> {
        return bookService.addBook(book)
    }

    @GetMapping("/book/{id}")
    public fun getBook(@PathVariable("id") id: String): Mono<Book> {
        return bookService.getBook(id)
    }

    @GetMapping("/books")
    public fun getBooks(): Flux<Book> {
        return bookService.getBooks()
    }

    @GetMapping("/book/bookUser/{bookUserId}")
    public fun getBorrowedBooksForBookUser(@PathVariable("bookUserId") bookUserId: String): Flux<Book> {
        return bookService.getBorrowedBooksForBookUser(bookUserId)
    }

    @GetMapping("/book/bookUser/past/{bookUserId}")
    public fun getPastBorrowedBooksForBookUser(@PathVariable("bookUserId") bookUserId: String): Flux<Book> {
        return bookService.getPastBorrowedBooksForBookUser(bookUserId)
    }
}