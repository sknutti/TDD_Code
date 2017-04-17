package com.stgconsulting.tdd


class Sum(val augend: Expression, val addend: Expression) : Expression {
    override fun times(multiplier: Int): Expression {
        return Sum(augend.times(multiplier), addend.times(multiplier))
    }

    override fun plus(addend: Expression): Expression {
        return Sum(this, addend)
    }

    override fun reduce(bank: Bank, to: String) : Money {
        val amount = augend.reduce(bank, to).amount.plus(addend.reduce(bank, to).amount)
        return Money(amount, to)
    }

}
