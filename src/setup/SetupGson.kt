package hu.martinhuszti.setup

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson

fun Application.setupGson() {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }
}