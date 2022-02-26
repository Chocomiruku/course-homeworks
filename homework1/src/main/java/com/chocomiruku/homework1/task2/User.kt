package com.chocomiruku.homework1.task2

import java.lang.Exception

enum class Type {
    DEMO, FULL
}

data class User(val id: Long, val name: String, val age: Int, val type: Type) {
    val startTime: Long by lazy {
        System.currentTimeMillis()
    }
}

fun User.checkAge() {
    if (age >= 18) {
        println("Success. User is over 18 years old.")
    } else throw Exception("User is under 18 years old.")
}