package hu.martinhuszti

import hu.martinhuszti.module.dashboardModule
import hu.martinhuszti.module.landingModule
import hu.martinhuszti.module.loginModule
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

val mongoUrl = System.getenv("mongourl")?.toString() ?: ""

fun main() {
    //for Heroku hosting
    val port = System.getenv("PORT")?.toInt() ?: 8080

    embeddedServer(Netty, port) {
        setupDependencies()

        landingModule()
        loginModule()
        dashboardModule()

    }.start(wait = true)
}


