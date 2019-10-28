package hu.martinhuszti

import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

inline fun withMongoDatabase(databaseInteraction: (CoroutineDatabase) -> Unit) {
    val mongoUrl by lazy {
        System.getenv("MONGOURL")?.toString() ?: "-"
    }
    val client = KMongo.createClient(mongoUrl).coroutine //use coroutine extension
    val database = client.getDatabase("monitor") //normal java driver usage

    //Call DB
    databaseInteraction.invoke(database)

    //Close client
    client.close()
}
