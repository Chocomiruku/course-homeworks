package com.chocomiruku.homework1.task2

interface AuthCallback {
    fun authSuccess()
    fun authFailed()
}

val anonymousAuthCallback = object : AuthCallback {
    override fun authSuccess() {
        println("Authorization was successful.")
    }

    override fun authFailed() {
        println("Authorization has failed.")
    }
}