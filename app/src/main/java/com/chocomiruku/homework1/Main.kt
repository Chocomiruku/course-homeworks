package com.chocomiruku.homework1

import com.chocomiruku.homework1.task1.Book
import com.chocomiruku.homework1.task1.Magazine
import com.chocomiruku.homework1.task1.Publication
import com.chocomiruku.homework1.task2.*

fun buy(purchase: Publication) {
    println("\nThe purchase is complete. The purchase amount was " + formatPrice(purchase.price))
}

fun runFirstTask() {
    // Exercise 1: Publication's info
    val bookFirst = Book(25.50, 1000)
    val bookSecond = Book(50.70, 7500)
    val magazine = Magazine(11.50, 10000)

    println(bookFirst.toString())
    println(bookSecond.toString())
    println(magazine.toString())

    // Exercise 2: Equality
    println("\nReferential equality: " + (bookFirst === bookSecond))
    println("Structural equality: " + (bookFirst == bookSecond))

    // Exercise 3: Null safety
    var nullableBookFirst: Book? = null
    var nullableBookSecond: Book? = Book(17.20, 500)

    nullableBookFirst?.let { buy(nullableBookFirst) }
    nullableBookSecond?.let { buy(nullableBookSecond) }

    // Exercise 4: Lambda
    val sum = { x: Int, y: Int -> x + y }
    println("\n27 + 17 = " + sum(27, 17))
}

fun runSecondTask() {
    // Exercise 2-3:  Data class with lazy property
    val user = User(id = 1, name = "Angelina", age = 20, type = Type.DEMO)

    println(convertLongToTimeString(user.startTime))
    Thread.sleep(1000)
    println(convertLongToTimeString(user.startTime))

    // Exercise 4: Scope function apply
    val users = mutableListOf(user)
    users.apply {
        this.add(User(id = 2, name = "Ivan", age = 25, type = Type.FULL))
        this.add(User(id = 3, name = "Maria", age = 30, type = Type.DEMO))
    }

    // Exercise 5: Filtering collections
    val usersWithFullAccess = users.filter { it.type == Type.FULL }

    // Exercise 6: Collection transformation operations
    val userNames = users.map { it.name }
    println("\nFirst element: " + userNames.first() + ", last element: " + userNames.last())

    // Exercises 7-12 : Extension function, anonymous object, inline, sealed class
    doAction(Action.Registration)
    doAction(Action.Login(user))
    doAction(Action.Logout)
}

fun main() {
    runFirstTask()
    runSecondTask()
}