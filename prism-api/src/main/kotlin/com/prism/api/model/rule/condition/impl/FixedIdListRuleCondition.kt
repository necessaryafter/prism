package com.prism.api.model.rule.condition.impl

import com.prism.api.model.rule.condition.EvaluationContext
import com.prism.api.model.rule.condition.RuleCondition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("FixedIdList")
class FixedIdListRuleCondition(val userIds: List<String>) : RuleCondition {

    override fun validate(
        context: EvaluationContext,
        salt: String,
    ): Boolean {
        val userId = context["userId"] ?: return false

        return userId in userIds
    }

}