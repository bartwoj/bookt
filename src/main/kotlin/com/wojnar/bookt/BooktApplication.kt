package com.wojnar.bookt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class BooktApplication

fun main(args: Array<String>) {
	runApplication<BooktApplication>(*args)
}
