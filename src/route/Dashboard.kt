package hu.martinhuszti.route

import hu.martinhuszti.Dashboard
import io.ktor.application.call
import io.ktor.locations.get
import io.ktor.response.respondFile
import io.ktor.routing.Route
import java.io.File

fun Route.dashboardModule() {
    get<Dashboard> {
        call.respondFile(File("resources/dashboard.json"))
    }

}
