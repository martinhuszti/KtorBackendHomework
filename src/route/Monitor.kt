package hu.martinhuszti.route

import hu.martinhuszti.Monitor
import hu.martinhuszti.model.monitor.Connection
import io.ktor.application.call
import io.ktor.locations.get
import io.ktor.response.respondText
import io.ktor.routing.Route
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo
import java.util.*

fun Route.monitorModule(mongoUrl: String?) {
    get<Monitor> {
        checkNotNull(mongoUrl)
        val client = KMongo.createClient(mongoUrl).coroutine //use coroutine extension
        val database = client.getDatabase("monitor") //normal java driver usage
        database.getCollection<Connection>("connection").insertOne(Connection(Date()))
        call.respondText { "Connection Monitor inserted" }
    }

}
