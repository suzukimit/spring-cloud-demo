package com.example.demo.sayhelloservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class SayHelloApplication

fun main(args: Array<String>) {
    runApplication<SayHelloApplication>(*args)
}
