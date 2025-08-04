package com.prism.core.table

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.datetime

object FlagsTable : LongIdTable("flags") {
    val name = varchar("name", 255)
    val description = text("description")
    val enabled = bool("enabled")
    val createdAt = datetime("created_at")
    val lastUpdatedAt = datetime("last_updated_at")
}