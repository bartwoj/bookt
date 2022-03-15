package com.wojnar.bookt.service

import com.wojnar.bookt.data.BookRepository
import com.wojnar.bookt.data.BookUserRepository
import com.wojnar.bookt.model.Book
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val bookUserRepository: BookUserRepository
) : BookService {

    public override fun addBook(book: Book): Mono<Book> {
        return bookRepository.insert(book)
    }

    public override fun getBook(id: String): Mono<Book> {
        return bookRepository.findById(id)
    }

    public override fun getBooks(): Flux<Book> {
        return bookRepository.findAll()
    }

    public override fun getBorrowedBooksForBookUser(bookUserId: String): Flux<Book> {
        return bookUserRepository.findById(bookUserId).flux()
            .flatMapIterable { bookUser -> bookUser.borrowedBooks }
            .flatMap { bookId -> bookRepository.findById(bookId) }
    }

    public override fun getPastBorrowedBooksForBookUser(bookUserId: String): Flux<Book> {
        return bookUserRepository.findById(bookUserId).flux()
            .flatMapIterable { bookUser -> bookUser.pastBorrowedBooks }
            .flatMap { bookId -> bookRepository.findById(bookId) }
    }
}