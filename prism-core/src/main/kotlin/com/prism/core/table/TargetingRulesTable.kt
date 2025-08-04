package com.prism.core.table

import org.jetbrains.exposed.dao.id.LongIdTable

object TargetingRulesTable : LongIdTable("targeting_rules") {
    val flagId = reference("flag_id", FlagsTable)
    val priority = integer("priority")
    val conditionJson = text("condition_json")
}
