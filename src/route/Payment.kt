package hu.martinhuszti.route

import hu.martinhuszti.Payment
import io.ktor.application.call
import io.ktor.locations.post
import io.ktor.response.respondFile
import io.ktor.routing.Route
import java.io.File
import kotlin.random.Random

/**
 * Pay for the package
 */
fun Route.paymentModule() {
    post<Payment> {
        val randomFileName = if (Random.nextBoolean()) "resources/paymentSuccess.json" else "resources/paymentFail.json"
        val paymentResponse = File(randomFileName)
        call.respondFile(paymentResponse)
    }
}
