package hu.martinhuszti.setup

import hu.martinhuszti.withMongoDatabase
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.UserPasswordCredential
import io.ktor.auth.basic
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun Application.setupAuth() {
    install(Authentication) {
        basic(name = "auth") {
            realm = "Ktor Server"

                withMongoDatabase { database ->
                    validate { credentials ->
                        val user = database
                            .getCollection<UserPasswordCredential>("user")
                            .findOne("{name:'${credentials.name}'}")
                            ?: return@validate null

                        if (user.password != credentials.password) return@validate null

                        UserIdPrincipal(credentials.name)
                    }
                }

        }
    }
}
