package io.dev.deneb

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

@RestController
@SpringBootApplication
class KotlinRestApiApplication {

    val log: Logger = LoggerFactory.getLogger(KotlinRestApiApplication::class.java)

    companion object{
        val customers = arrayOf(
            Customer(1, "Kim"),
            Customer(2, "Lee"),
            Customer(3, "Park"),
        )
    }

    @Bean
    fun customers() = ConcurrentHashMap(
        customers.associateBy(Customer::id)
    )
}

fun main(args: Array<String>) {
    runApplication<KotlinRestApiApplication>(*args)
}
