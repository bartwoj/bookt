package com.wojnar.bookt

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication

@SpringBootApplication
class BooktApplication

fun main(args: Array<String>) {
	SpringApplicationBuilder(BooktApplication::class.java)
		.run(*args)
//	runApplication<BooktApplication>(*args)
//	SpringApplication
//		.run(BooktApplication::class.java, *args)
}
