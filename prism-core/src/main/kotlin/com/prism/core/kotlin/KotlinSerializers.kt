package com.prism.core.kotlin

import com.prism.api.model.rule.condition.RuleCondition
import com.prism.api.model.rule.condition.impl.AttributeMatchRuleCondition
import com.prism.api.model.rule.condition.impl.DateWindowRuleCondition
import com.prism.api.model.rule.condition.impl.FixedIdListRuleCondition
import com.prism.api.model.rule.condition.impl.PercentageRuleCondition
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import java.time.Instant

internal val PrismSerializer = Json {
    prettyPrint = true
    encodeDefaults = false
    ignoreUnknownKeys = true
    useArrayPolymorphism = false
    explicitNulls = false

    serializersModule = SerializersModule {
        contextual(Instant::class, InstantSerializer)

        polymorphic(RuleCondition::class) {
            subclass(AttributeMatchRuleCondition::class, AttributeMatchRuleCondition.serializer())
            subclass(DateWindowRuleCondition::class, DateWindowRuleCondition.serializer())
            subclass(FixedIdListRuleCondition::class, FixedIdListRuleCondition.serializer())
            subclass(PercentageRuleCondition::class, PercentageRuleCondition.serializer())
        }

        classDiscriminator = "type"
    }
}

internal object InstantSerializer : KSerializer<Instant> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("InstantSerializer", PrimitiveKind.LONG)

    override fun serialize(encoder: Encoder, value: Instant) {
        encoder.encodeLong(value.toEpochMilli())
    }

    override fun deserialize(decoder: Decoder): Instant {
        return Instant.ofEpochMilli(decoder.decodeLong())
    }
}
