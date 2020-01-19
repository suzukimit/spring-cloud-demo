package com.example.demo.sayhelloservice

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class SayHelloController {
    companion object {
        private val log = LoggerFactory.getLogger(SayHelloController::class.java)
    }

    @Value("\${server.port}")
    lateinit var port: String

    @RequestMapping(value = "/greeting")
    fun greet(): String {
        log.info("Access /greeting")

        val greetings = listOf("Hi there", "Greetings", "Salutations")
        val rand = Random()

        val randomNum = rand.nextInt(greetings.size)
        return greetings[randomNum] + "(from $port)"
    }

    @RequestMapping(value = "/")
    fun home(): String {
        log.info("Access /")
        return "Hi!"
    }
}