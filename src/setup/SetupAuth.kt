package hu.martinhuszti.setup

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.basic

fun Application.setupAuth() {
    install(Authentication) {
        basic(name = "auth") {
            realm = "Ktor Server"
            val correctName = System.getenv("NAME")?.toString()
            val correctPassword = System.getenv("PASSWORD")?.toString()

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
