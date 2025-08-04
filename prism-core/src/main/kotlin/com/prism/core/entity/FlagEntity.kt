package com.prism.core.entity

import com.prism.core.table.FlagsTable
import com.prism.core.table.TargetingRulesTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class FlagEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<FlagEntity>(FlagsTable)

    var name by FlagsTable.name
    var description by FlagsTable.description
    var enabled by FlagsTable.enabled
    var createdAt by FlagsTable.createdAt
    var lastUpdatedAt by FlagsTable.lastUpdatedAt

    val targetingRules by TargetingRuleEntity referrersOn TargetingRulesTable.flagId
}