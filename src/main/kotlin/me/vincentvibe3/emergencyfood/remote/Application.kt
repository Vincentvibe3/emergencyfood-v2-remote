package me.vincentvibe3.emergencyfood.remote

import io.ktor.application.*
import me.vincentvibe3.emergencyfood.remote.routes.api
import me.vincentvibe3.emergencyfood.remote.routes.auth
import me.vincentvibe3.emergencyfood.remote.routes.root

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    root()
    auth()
    api()
}

