package hu.martinhuszti.route

import hu.martinhuszti.Monitor
import hu.martinhuszti.model.Connection
import hu.martinhuszti.withMongoDatabase
import io.ktor.application.call
import io.ktor.locations.get
import io.ktor.response.respondText
import io.ktor.routing.Route
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

/**
 * Insert monitor document to connection collection
 */
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
