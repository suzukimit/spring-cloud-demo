package com.example.demo.userservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackageClasses = [UserApplication::class])
class UserApplication

fun main(args: Array<String>) {
    runApplication<UserApplication>(*args)
}
