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
}