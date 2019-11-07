package hu.martinhuszti.route.bankcard

import com.mongodb.reactivestreams.client.Success
import hu.martinhuszti.AddBankCard
import hu.martinhuszti.model.BankCard
import hu.martinhuszti.withMongoDatabase
import io.ktor.application.call
import io.ktor.locations.post
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.Route
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun Route.addBankCardModule() {
    post<AddBankCard> {
        val bankCard = call.receive<BankCard>()

        GlobalScope.launch {
            withMongoDatabase {
                it.getCollection<BankCard>("bankcard").insertOne(bankCard)
            }
        }
        call.respondText { "Bankcard saved!" }
    }
}