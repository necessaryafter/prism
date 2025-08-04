package com.prism.core.model.flag

import com.prism.api.model.flag.Flag
import com.prism.api.model.rule.TargetingRule
import java.time.LocalDateTime

class FlagImpl(
    override val id: Long,
    override val name: String,
    override val description: String,
    override val rules: List<TargetingRule>,
    override val createdAt: LocalDateTime,
    override val lastUpdatedAt: LocalDateTime,
    override var enabled: Boolean
) : Flag
