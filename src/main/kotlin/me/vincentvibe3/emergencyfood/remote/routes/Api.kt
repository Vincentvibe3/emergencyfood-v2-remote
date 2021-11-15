package me.vincentvibe3.emergencyfood.remote.routes

import io.ktor.application.*
import io.ktor.routing.*

fun Application.api() {
    routing {
        route ("/api"){
            //put api versions here and other api endpoints
            v1()
        }
    }
}

fun Route.v1(){
    route("/v1"){
        //place api endpoints here
    }
}