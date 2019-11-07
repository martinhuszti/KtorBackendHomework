package hu.martinhuszti.setup

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson

/**
 * Set up the GSON parser
 */
fun Application.setupGSON() {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }
}