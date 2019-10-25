package hu.martinhuszti.module

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.post
import io.ktor.routing.routing

fun Application.loginModule() {
    routing {
        post("/login") {
            call.respond(mapOf("success" to true))
        }
    }
}