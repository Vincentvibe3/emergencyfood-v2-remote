package me.vincentvibe3.emergencyfood.remote.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.client.request.*
import io.ktor.client.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.utils.io.*

fun Application.auth() {
    routing {
        //place non-api user authentication routes here
        register()
        oauth()
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

fun Route.oauth() {
    route("/oauth"){
        get {
            val token = call.parameters["code"]
            val error = call.parameters["error"]
            val errorDescription = call.parameters["error_description"]
            when (token){
                null -> {
                    call.respondText("An error occurred\n$error")
                }
                else -> {
                    val client = HttpClient()
                    val postResponse:HttpResponse = client.submitForm(
                        url= "https://discord.com/api/oauth2/token",
                        formParameters = Parameters.build {
                            append("client_id", "")
                            append("client_secret", "")
                            append("grant_type", "authorization_code")
                            append("code", token)
                            append("redirect_uri", "http://localhost:8080/oauth")
                        }
                    )
                    println(postResponse.readText())
                    val response:HttpResponse = client.get("https://discord.com/api/users/")

                    call.respondText(response.readText())
                }
            }

        }
    }

}