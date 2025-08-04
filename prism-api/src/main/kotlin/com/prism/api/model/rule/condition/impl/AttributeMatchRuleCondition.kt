package com.prism.api.model.rule.condition.impl

import com.prism.api.model.rule.condition.EvaluationContext
import com.prism.api.model.rule.condition.RuleCondition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("AttributeMatch")
data class AttributeMatchRuleCondition(
    val attribute: String,
    val operator: Operator,
    val value: String
) : RuleCondition {
    enum class Operator {
        EQUALS,
        NOT_EQUALS,
        ENDS_WITH,
        STARTS_WITH,
        CONTAINS,
        GREATER_THAN,
        LESS_THAN
    }

    override fun validate(context: EvaluationContext, salt: String): Boolean {
        val attributeValue = context[attribute] ?: return false

        return when (operator) {
            Operator.EQUALS -> attributeValue == value
            Operator.NOT_EQUALS -> attributeValue != value
            Operator.ENDS_WITH -> attributeValue.endsWith(value)
            Operator.STARTS_WITH -> attributeValue.startsWith(value)
            Operator.CONTAINS -> attributeValue.contains(value)
            Operator.GREATER_THAN -> compare(attributeValue, value) > 0
            Operator.LESS_THAN -> compare(attributeValue, value) < 0
        }
    }

    private fun compare(a: String, b: String): Int {
        val aNum = a.toDoubleOrNull()
        val bNum = b.toDoubleOrNull()
        return if (aNum != null && bNum != null) {
            aNum.compareTo(bNum)
        } else {
            a.compareTo(b)
        }
    }
}