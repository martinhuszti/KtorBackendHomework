package hu.martinhuszti.module

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respondFile
import io.ktor.routing.get
import io.ktor.routing.routing
import java.io.File

fun Application.dashboardModule() {
    routing {
        get("/dashboard") {
            call.respondFile(File("resources/dashboard.json"))
        }
    }
}