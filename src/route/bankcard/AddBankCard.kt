package hu.martinhuszti.route.bankcard

import hu.martinhuszti.AddBankCard
import hu.martinhuszti.withMongoDatabase
import io.ktor.application.call
import io.ktor.locations.post
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.Route
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

data class BankCards(
    val number: String = "xxxx-xxxx-xxxx-xxxx",
    val expires: String = "0000",
    val name: String = "Példakártya",
    val cardholder: String = "Példa János"
)

fun Route.addBankCardModule() {
    post<AddBankCard> {
        val bankCard = call.receive<BankCards>()

        GlobalScope.launch {
            withMongoDatabase {
                it.getCollection<BankCards>("bankcard").insertOne(bankCard)
            }
        }
        call.respondText { "Bankcard saved!" }
    }
}
