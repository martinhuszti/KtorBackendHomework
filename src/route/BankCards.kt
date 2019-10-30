package hu.martinhuszti.route

import hu.martinhuszti.AllBankCard
import io.ktor.application.call
import io.ktor.locations.get
import io.ktor.response.respondFile
import io.ktor.routing.Route
import java.io.File


fun Route.bankCardsModule() {
    get<AllBankCard> {
        call.respondFile(File("resources/bankcards.json"))
    }
}
