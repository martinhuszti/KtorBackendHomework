package hu.martinhuszti.setup

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.basic

/**
 * Set up Basic Authentication
 */
fun Application.setupAuth() {
    install(Authentication) {
        basic(name = "auth") {
            realm = "Martin's Ktor Server"
            val correctName = System.getenv("NAME")?.toString() ?: "asd"
            val correctPassword = System.getenv("PASSWORD")?.toString() ?: "asd"
            validate { credentials ->
                if (credentials.name == correctName && credentials.password == correctPassword) {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }

        }
    }
}
