package com.onlineclass.onlineclassapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OnlineClassApplication

fun main(args: Array<String>) {
	runApplication<OnlineClassApplication>(*args)
}
