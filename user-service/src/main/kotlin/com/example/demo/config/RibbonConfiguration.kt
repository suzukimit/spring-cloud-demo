package com.example.demo.config

import com.netflix.loadbalancer.AvailabilityFilteringRule
import com.netflix.loadbalancer.IPing
import com.netflix.loadbalancer.IRule
import com.netflix.loadbalancer.PingUrl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RibbonConfiguration {

    @Bean
    fun ribbonPing(): IPing {
        return PingUrl()
    }

    @Bean
    fun ribbonRule(): IRule {
        return AvailabilityFilteringRule()
    }
}