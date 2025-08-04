package com.prism.api.model.rule.condition

typealias EvaluationContext = Map<String, String>

interface RuleCondition {

    fun validate(context: EvaluationContext, salt: String): Boolean

}

