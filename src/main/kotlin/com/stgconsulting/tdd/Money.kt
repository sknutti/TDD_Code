package com.stgconsulting.tdd

class Money(val amount: Int, val currency: String) : Expression {

    override fun times(multiplier: Int) : Expression {
        return Money(amount * multiplier, currency)
    }

    override fun plus(addend: Expression) : Expression {
        return Sum(this, addend)
    }

    override fun reduce(bank: Bank, to: String) : Money {
        val rate = bank.rate(currency, to)
        return Money(amount/rate, to)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Money

        if (amount != other.amount) return false
        if (currency != other.currency) return false

        return true
    }

    override fun hashCode(): Int {
        var result = amount
        result = 31 * result + currency.hashCode()
        return result
    }

    companion object {
        @JvmStatic
        fun dollar(amount: Int) : Money {
            return Money(amount, "USD")
        }

        @JvmStatic
        fun franc(amount: Int) : Money {
            return Money(amount, "CHF")
        }
    }
}
