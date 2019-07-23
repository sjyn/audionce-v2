package com.newline.sjyn.audionce

import com.newline.sjyn.audionce.route.sound.sound
import com.newline.sjyn.audionce.route.user.users
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.jetbrains.exposed.sql.Database
import java.text.DateFormat

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }

    routing {
        users()
        sound()
    }
}

fun main(args: Array<String>) {
    Database.connect("", driver="org.h2.Driver")
    embeddedServer(Netty, 8080, watchPaths = listOf("AppKt"), module = Application::module).start()
}