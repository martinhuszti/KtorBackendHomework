@file:Suppress("EXPERIMENTAL_API_USAGE")

package hu.martinhuszti

import hu.martinhuszti.route.*
import hu.martinhuszti.route.bankcard.addBankCardModule
import hu.martinhuszti.route.bankcard.bankCardsModule
import hu.martinhuszti.setup.setupAuth
import hu.martinhuszti.setup.setupGson
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
class AllBankCard

@Location("/pay")
class Payment


fun main() {
    val port = System.getenv("PORT")?.toInt() ?: 8080

    embeddedServer(Netty, port) {
        setupGson()
        setupAuth()
        install(AutoHeadResponse)
        install(Locations)


        routing {
            authenticate("auth") {
                landing()
                loginModule()
                dashboardModule()
                addBankCardModule()
                bankCardsModule()
                paymentModule()
            }

            // no need for auth
            monitorModule()

        }


    }.start(wait = true)
}


