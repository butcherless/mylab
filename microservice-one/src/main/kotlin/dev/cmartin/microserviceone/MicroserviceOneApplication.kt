package dev.cmartin.microserviceone

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroserviceOneApplication

fun main(args: Array<String>) {
	runApplication<MicroserviceOneApplication>(*args)
}
