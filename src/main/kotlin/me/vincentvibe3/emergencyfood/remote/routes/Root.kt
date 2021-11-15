package me.vincentvibe3.emergencyfood.remote.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.root() {
    routing {
        //place web pages served on the root of the website
        root()
    }
}

fun Route.root() {
    route("/"){
        get {
            call.respondText("This is /")
        }
    }
}
