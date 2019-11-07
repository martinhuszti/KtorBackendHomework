package hu.martinhuszti.route

import hu.martinhuszti.Login
import io.ktor.application.call
import io.ktor.locations.post
import io.ktor.response.respond
import io.ktor.routing.Route

/**
 * If basic auth if correct the server respond to the client
 */
fun Route.loginModule() {
    post<Login> {
            call.respond(mapOf("success" to true))
        }
}
