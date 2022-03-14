package com.wojnar.bookt.data

import com.wojnar.bookt.model.Book
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BookRepository: ReactiveMongoRepository<Book, String> {
    override fun findById(id: String): Mono<Book>
    fun findByTitle(title: String): Mono<Book>
    override fun findAll(): Flux<Book>
    fun insert(book: Book): Mono<Book>
    override fun deleteAll(): Mono<Void>
}
