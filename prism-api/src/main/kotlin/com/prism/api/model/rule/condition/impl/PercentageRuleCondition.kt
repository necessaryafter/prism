package com.prism.api.model.rule.condition.impl

import com.google.common.hash.Hashing
import com.prism.api.model.rule.condition.EvaluationContext
import com.prism.api.model.rule.condition.RuleCondition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.math.abs

@Serializable
@SerialName("Percentage")
data class PercentageRuleCondition(val percentage: Int) : RuleCondition {

    override fun validate(
        context: EvaluationContext,
        salt: String,
    ): Boolean {
        val userId = context["userId"] ?: return false

        return validateHash(userId, salt)
    }

    private fun validateHash(userId: String, salt: String) : Boolean {
        if (percentage <= 0) return false
        if (percentage >= 100) return true

        val hashCode = Hashing
            .murmur3_32_fixed()
            .hashString(userId + salt, Charsets.UTF_8)
            .asInt()

        val normalizedValue = abs(hashCode % 100)
        return normalizedValue < percentage
    }
}