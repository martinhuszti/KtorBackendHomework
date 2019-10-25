package hu.martinhuszti

import hu.martinhuszti.module.dashboardModule
import hu.martinhuszti.module.landingModule
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty


fun main() {
    //for Heroku hosting
    val port = System.getenv("PORT")?.toInt() ?: 8080
    embeddedServer(Netty, port) {
        setupDependencies()

        landingModule()
        dashboardModule()

    }.start(wait = true)
}


