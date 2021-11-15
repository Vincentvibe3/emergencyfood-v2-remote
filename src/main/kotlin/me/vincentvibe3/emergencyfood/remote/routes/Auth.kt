package me.vincentvibe3.emergencyfood.remote.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.auth() {
    routing {
        //place non-api user authentication routes here
        register()
        login()
    }
}

fun Route.register() {
    route("/register"){

        get {
            call.respondText("This is /register")
        }

        post {
            val customer = call.receiveParameters()
            val userName = customer["username"]
            call.application.environment.log.info("register called")
            call.respondText("Hello $userName", status = HttpStatusCode.OK)
        }
    }

}

fun Route.login() {
    route("/login"){
        get {
            call.respondText("This is /login")
        }

        post {
            val customer = call.receiveParameters()
            val userName = customer["username"]
            call.respondText("Hello $userName", status = HttpStatusCode.OK)
        }
    }

}