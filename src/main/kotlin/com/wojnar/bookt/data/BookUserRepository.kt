package com.wojnar.bookt.data

import com.wojnar.bookt.model.BookUser
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface BookUserRepository: ReactiveMongoRepository<BookUser, String> {

}
