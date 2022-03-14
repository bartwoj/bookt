package com.wojnar.bookt.controller

import com.wojnar.bookt.data.BookRepository
import com.wojnar.bookt.data.BookUserRepository
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController (
    bookRepository: BookRepository,
    bookUserRepository: BookUserRepository
        ){
}