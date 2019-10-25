package hu.martinhuszti

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson

fun Application.setupDependencies() {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }
}