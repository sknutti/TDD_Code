package com.stgconsulting.tdd

class Bank {

    private val rates = HashMap<Pair<String,String>, Int>()

    fun reduce(source: Expression, to: String) : Money {
        return source.reduce(this, to)
    }

    fun addRate(from: String, to: String, rate: Int) {
        rates.put(Pair(from,to), rate)
    }

    fun getRate(from: String, to: String) : Int {
        return rates[Pair(from, to)]!!.toInt()
    }

    fun rate(from: String, to: String) : Int {
        val rate: Int?

        if (from == to) return 1

        if (from == "CHF" && to == "USD") {
            rate = 2
        } else {
            rate = 1
        }
        return rate
    }
}
