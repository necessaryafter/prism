package com.prism.core

import com.prism.core.database.DatabaseConnector
import com.prism.core.table.FlagsTable
import io.ktor.server.application.Application
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.configureClient() {
    DatabaseConnector.connectAndCreateTable()

}
