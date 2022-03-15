package com.wojnar.bookt.data

import com.wojnar.bookt.model.BookUser
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BookUserRepository: ReactiveMongoRepository<BookUser, String> {
    override fun findById(id: String): Mono<BookUser>
    fun findByName(title: String): Mono<BookUser>
    override fun findAll(): Flux<BookUser>
    fun insert(bookUser: BookUser): Mono<BookUser>
    override fun deleteAll(): Mono<Void>
}
