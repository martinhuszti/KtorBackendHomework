package hu.martinhuszti.route

import hu.martinhuszti.Landing
import io.ktor.application.call
import io.ktor.locations.get
import io.ktor.response.respondText
import io.ktor.routing.Route


fun Route.landing() {
    get<Landing> {
        call.respondText { "Welcome to my new ktor Backend server on Heroku!" }
    }
}
