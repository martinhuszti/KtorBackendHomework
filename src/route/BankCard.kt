@file:JvmName("BankCardKt")

package hu.martinhuszti.route

import com.google.gson.Gson
import hu.martinhuszti.AddBankCard
import hu.martinhuszti.ListAllBankCards
import hu.martinhuszti.model.BankCard
import hu.martinhuszti.withMongoDatabase
import io.ktor.application.call
import io.ktor.locations.get
import io.ktor.locations.post
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.Route
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun Route.bankCardModule() {
    // Add a bank card to collection
    post<AddBankCard> {
        val bankCard = call.receive<BankCard>()
        GlobalScope.launch {
            withMongoDatabase {
                it.getCollection<BankCard>("bankcard").insertOne(bankCard)
            }
        }
        call.respondText { "Bankcard saved!" }
    }

    // Get all bankcard
    get<ListAllBankCards> {
        withMongoDatabase { database ->
            val collection = database.getCollection<BankCard>("bankcard").find().toList()
            call.respondText { Gson().toJson(collection) }
        }
    }
}
