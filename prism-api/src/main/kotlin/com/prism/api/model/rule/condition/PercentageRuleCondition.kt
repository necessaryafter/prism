package com.prism.api.model.rule.condition

import com.google.common.hash.Hashing
import kotlin.math.abs

data class PercentageRolloutRuleCondition(val percentage: Int) : RuleCondition {

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