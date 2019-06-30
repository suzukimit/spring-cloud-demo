package com.example.demo

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.client.RestTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.ribbon.RibbonClient
import org.springframework.context.annotation.Bean


@RestController
@RibbonClient(name = "say-hello", configuration = [RibbonConfiguration::class])
class UserController {
    @LoadBalanced
    @Bean
    fun restTemplate() = RestTemplate()

    @Autowired
    lateinit var restTemplate: RestTemplate

    @RequestMapping("/hi")
    fun hi(@RequestParam(value = "name", defaultValue = "Artaban") name: String): String {
        val greeting = this.restTemplate.getForObject("http://say-hello/greeting", String::class.java)
        return String.format("%s, %s!", greeting, name)
    }
}