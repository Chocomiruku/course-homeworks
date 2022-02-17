package com.chocomiruku.homework1.task1

import com.chocomiruku.homework1.formatPrice

class Book(override val price: Double, override val wordCount: Int) : Publication {
    override fun getType(): String {
        return when {
            wordCount in 1..1000 -> "Flash Fiction"
            wordCount in 1001..7500 -> "Short Story"
            wordCount <= 0 -> throw IllegalArgumentException("WordCount should be positive")
            else -> "Novel"
        }
    }

    override fun equals(other: Any?): Boolean {
        return other is Book && other.price == this.price && other.wordCount == this.wordCount
    }

    override fun toString(): String {
        return "Type: " + getType() + "\n" + "Price: " + formatPrice(price) + ", Words: " + wordCount
    }
}