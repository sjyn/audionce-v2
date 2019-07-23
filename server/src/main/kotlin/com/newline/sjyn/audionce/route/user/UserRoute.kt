package com.newline.sjyn.audionce.route.user

import com.newline.sjyn.audionce.model.UserData
import com.newline.sjyn.audionce.model.UserLogin
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.post
import io.ktor.routing.route

fun Routing.users() {
    route("/user") {
        post("/login") {
            with(call.receive<UserLogin>()) {
                UserApi.loginUser(this)
            }
        }
        post("/logout") {

        }
        post("/") {
            val updatedData = with(call.receive<UserData>()) { UserApi.createUser(this) }
            call.respond(updatedData)
        }
    }
}