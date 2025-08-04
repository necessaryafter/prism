package com.prism.api.model.flag

import com.prism.api.model.rule.TargetingRule
import java.time.LocalDateTime

interface Flag {
    val id: Long
    val name: String
    val description: String
    val rules: List<TargetingRule>
    
    val createdAt: LocalDateTime
    val lastUpdatedAt: LocalDateTime

    var enabled: Boolean
}