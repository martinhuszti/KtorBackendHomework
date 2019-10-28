package hu.martinhuszti.route

import hu.martinhuszti.Monitor
import hu.martinhuszti.model.monitor.Connection
import hu.martinhuszti.withMongoDatabase
import io.ktor.application.call
import io.ktor.locations.get
import io.ktor.response.respondText
import io.ktor.routing.Route
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

fun Route.monitorModule() {
    get<Monitor> {
        GlobalScope.launch {
            withMongoDatabase { database ->
                database.getCollection<Connection>("connection").insertOne(Connection(Date()))
            }
        }

        call.respondText { "Connection Monitor inserted" }
    }

}
