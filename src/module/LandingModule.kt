package hu.martinhuszti.module

import hu.martinhuszti.url
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun Application.landingModule() {


    routing {
        get("/") {
            val client = KMongo.createClient(url).coroutine //use coroutine extension
            val database = client.getDatabase("test") //normal java driver usage
            database.createCollection("asd")
            call.respondText { "das" }
        }
    }
}