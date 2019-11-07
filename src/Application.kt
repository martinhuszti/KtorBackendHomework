@file:Suppress("EXPERIMENTAL_API_USAGE")

package hu.martinhuszti

import hu.martinhuszti.route.*
import hu.martinhuszti.setup.setupAuth
import hu.martinhuszti.setup.setupGSON
import io.ktor.application.install
import io.ktor.auth.authenticate
import io.ktor.features.AutoHeadResponse
import io.ktor.locations.Location
import io.ktor.locations.Locations
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty


@Location("/")
class Landing

@Location("/login")
data class Login(val userId: String = "", val password: String = "123")

@Location("/connect")
class Monitor

@Location("/dashboard")
class Dashboard

@Location("/addbankcard")
class AddBankCard

@Location("/bankcards")
class ListAllBankCards

@Location("/pay")
class Payment


fun main() {
    val port = System.getenv("PORT")?.toInt() ?: 8080
    val server = embeddedServer(Netty, port) {
        setupGSON()
        setupAuth()
        install(AutoHeadResponse)
        install(Locations)


        routing {
            // Need authentication to reach these endpoints
            authenticate("auth") {
                landingPage()
                loginModule()
                dashboardModule()
                bankCardModule()
                paymentModule()
            }
            // No need to auth
            monitorModule()
        }
    }
    server.start(wait = true)
}


