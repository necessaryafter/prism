package com.prism.core.database

import com.prism.core.table.FlagsTable
import com.prism.core.table.TargetingRulesTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.slf4j.LoggerFactory
import java.sql.SQLException

object DatabaseConnector {
    private val logger = LoggerFactory.getLogger(DatabaseConnector::class.java)

    private val DATABASE_URL = System.getenv("DATABASE_URL") ?: "jdbc:postgresql://localhost:5432/prism"
    private val DATABASE_USER = System.getenv("DATABASE_USER") ?: "postgres"
    private val DATABASE_PASS = System.getenv("DATABASE_PASS") ?: "123"

    fun connectAndCreateTable() {
        try {
            Database.connect(
                url = DATABASE_URL,
                driver = "org.postgresql.Driver",
                user = DATABASE_USER,
                password = DATABASE_PASS
            )

            transaction {
                SchemaUtils.create(FlagsTable, TargetingRulesTable)
            }

            logger.info("Successful database connected!")
        } catch (e: SQLException) {
            logger.error("Can't connect to database! (SQLException)", e)
        } catch (e: ExposedSQLException) {
            logger.error("An error occurred! (ExposedSQLException)", e)
        } catch (e: Exception) {
            logger.error("An unknown error occurred!", e)
        }
    }
}
