package com.chocomiruku.homework1.task1

import com.chocomiruku.homework1.formatPrice

class Magazine(override val price: Double, override val wordCount: Int) : Publication {
    override fun getType(): String {
        return if (wordCount > 0) "Magazine" else throw IllegalArgumentException("WordCount should be positive")
    }

    override fun toString(): String {
        return "Type: " + getType() + "\n" + "Price: " + formatPrice(price) + ", Words: " + wordCount
    }
}