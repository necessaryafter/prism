package com.prism.api.model.rule

import com.prism.api.model.rule.condition.RuleCondition

interface TargetingRule {
    val id: Long
    val priority: Int
    val ruleCondition: RuleCondition
}