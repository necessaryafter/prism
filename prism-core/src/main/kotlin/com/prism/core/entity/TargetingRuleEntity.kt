package com.prism.core.entity

import com.prism.core.table.TargetingRulesTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class TargetingRuleEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<TargetingRuleEntity>(TargetingRulesTable)

    var flag by FlagEntity referencedOn TargetingRulesTable.flagId
    var priority by TargetingRulesTable.priority
    var conditionJson by TargetingRulesTable.conditionJson
}