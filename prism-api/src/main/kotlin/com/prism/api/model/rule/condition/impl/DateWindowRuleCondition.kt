package com.prism.api.model.rule.condition.impl

import com.prism.api.model.rule.condition.EvaluationContext
import com.prism.api.model.rule.condition.RuleCondition
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
@SerialName("DateWindow")
data class DateWindowRuleCondition(
    @Contextual val start: Instant,
    @Contextual val end: Instant
) : RuleCondition {

    override fun validate(context: EvaluationContext, salt: String): Boolean {
        val now = Instant.now()
        val isAfterOrOnStart = now.isAfter(start)
        val isBeforeEnd = now.isBefore(end)

        return isAfterOrOnStart && isBeforeEnd
    }
}