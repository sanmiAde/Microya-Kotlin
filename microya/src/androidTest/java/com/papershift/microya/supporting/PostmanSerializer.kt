package com.papershift.microya.supporting

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object PostmanSerializer {
    private val module = SerializersModule {
        polymorphic(Any::class) {
            subclass(FooBar::class)
        }
    }

    val requestJsonFormatter = Json {
        serializersModule = module
    }
    val responseJsonFormatter: Json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
}