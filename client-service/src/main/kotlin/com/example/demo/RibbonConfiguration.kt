package com.example.demo

import com.netflix.client.config.IClientConfig
import com.netflix.loadbalancer.AvailabilityFilteringRule
import com.netflix.loadbalancer.IPing
import com.netflix.loadbalancer.IRule
import com.netflix.loadbalancer.PingUrl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean

class RibbonConfiguration {

    @Autowired
    lateinit var ribbonClientConfig: IClientConfig

    @Bean
    fun ribbonPing(config: IClientConfig): IPing {
        return PingUrl()
    }

    @Bean
    fun ribbonRule(config: IClientConfig): IRule {
        return AvailabilityFilteringRule()
    }
}