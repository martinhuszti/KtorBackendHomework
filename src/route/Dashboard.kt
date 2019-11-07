package hu.martinhuszti.route

import hu.martinhuszti.Dashboard
import io.ktor.application.call
import io.ktor.locations.get
import io.ktor.response.respondFile
import io.ktor.routing.Route
import java.io.File

/**
 * Respond a static JSON file with the packages available
 */
fun Route.dashboardModule() {
    get<Dashboard> {
        call.respondFile(File("resources/dashboard.json"))
    }
}
