package com.wojnar.bookt.controller

import com.wojnar.bookt.data.BookRepository
import com.wojnar.bookt.model.Book
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class BookController(
    private val bookRepository: BookRepository
    ) {

    @PostMapping("/book/save")
    public fun addBook(@RequestBody book: Book): Mono<Book> {
        return bookRepository.insert(book)
    }

    @GetMapping("/book/{id}")
    public fun getBook(@PathVariable("id") id: String): Mono<Book> {
        return bookRepository.findById(id)
    }

    @GetMapping("/books")
    public fun getBooks(): Flux<Book> {
        return bookRepository.findAll()
    }
}