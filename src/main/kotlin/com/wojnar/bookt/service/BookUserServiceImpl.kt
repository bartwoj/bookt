package com.wojnar.bookt.service

import com.wojnar.bookt.data.BookRepository
import com.wojnar.bookt.data.BookUserRepository
import com.wojnar.bookt.model.BookUser
import org.springframework.data.mongodb.core.*
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Service
class BookUserServiceImpl(
    private val bookRepository: BookRepository,
    private val bookUserRepository: BookUserRepository
) : BookUserService {

//    var a: ReactiveMongoOperations = ReactiveMongoTemplate(SimpleReactiveMongoDatabaseFactory())
//    var mongoOps: MongoOperations = MongoTemplate(SimpleMongoDbFactory(Mongo(), "database"))

    public override fun getBookUser(id: String): Mono<BookUser> {
        return bookUserRepository.findById(id)
    }

    public override fun getBookUsers(): Flux<BookUser> {
        return bookUserRepository.findAll()
    }

    public override fun addBookUser(bookUser: BookUser): Mono<BookUser> {
        return bookUserRepository.insert(bookUser)
    }

    public override fun borrowBookForBookUser(bookUserId: String, bookId: String): Mono<BookUser> {
        return bookRepository.existsById(bookId)
            .filter { exists -> exists }
            .flatMap { bookUserRepository.findById(bookUserId)}
            .doOnNext { bookUser -> bookUser.borrowBook(bookId) }
            .flatMap { bookUser -> bookUserRepository.insert(bookUser) }
    }
}