package hu.martinhuszti

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine

lateinit var server: NettyApplicationEngine

fun main(args: Array<String>): Unit {
    val port = System.getenv("PORT")?.toInt() ?: 8080
    server = embeddedServer(Netty, port) {
        routing {
            get("/") {
                call.respondText { "das" }
            }
        }
    }.start(wait = true)

}

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
}

