package hu.martinhuszti

import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

/**
 * Closure for open MongoDb client and make DB actions
 */
inline fun withMongoDatabase(function: (CoroutineDatabase) -> Unit) {
    val mongoUrl by lazy {
        System.getenv("MONGOURL")?.toString()
            ?: throw Exception("No MongoDB URL defined. Are you sure it's running on Heroku?")
    }
    val client = KMongo.createClient(mongoUrl).coroutine //use coroutine extension
    val database = client.getDatabase("monitor") //normal java driver usage
    //Call DB
    function.invoke(database)
    //Close client
    client.close()
}
