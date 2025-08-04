package com.prism.core.model.rule

import com.prism.api.model.rule.TargetingRule
import com.prism.api.model.rule.condition.RuleCondition

data class TargetingRuleImpl(
    override val id: Long,
    override val priority: Int,
    override val ruleCondition: RuleCondition
) : TargetingRule