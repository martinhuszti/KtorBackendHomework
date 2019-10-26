package hu.martinhuszti.route

import hu.martinhuszti.Login
import io.ktor.application.call
import io.ktor.locations.post
import io.ktor.response.respond
import io.ktor.routing.Route

fun Route.loginModule() {
    post<Login> {
        //TODO val user = call.sessions.get()?.let { dao.user(it.userId) }
            call.respond(mapOf("success" to true))
        }
}
