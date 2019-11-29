package com.guanhong.lambdapractice

val stringList = listOf("AAA", "BBB", "CCC")
val listLambda = { element: String ->
    Unit

    println(element)
}

fun <GuanHong> List<GuanHong>.GuanHongForEach(function: (GuanHong) -> Unit) {

    for (element in this) {
        println(element)
    }
}

fun listPractice() {

    for (element in stringList) {
        println(element)
    }

    stringList.forEach(listLambda)

    stringList.forEach({ element ->

        println(element)
    })

    stringList.forEach() { element ->

        println(element)
    }

    stringList.forEach { element ->

        println(element)
    }

    stringList.forEach {

        println(it)
    }

    stringList.GuanHongForEach(::println)
}

fun infix() {

    val lambdaPractice = LambdaPractice()

    val addOneToString = { a: Int -> (a + 1).toString() }

    infix fun LambdaPractice.andThenInfix(op: ((Int) -> String)): String {
        return op(0)
    }

    lambdaPractice.andThenInfix(addOneToString)
    lambdaPractice andThenInfix addOneToString
}

fun typeAlias() {

    fun myType.test(op: ((myType) -> Int)): myType {

        return {
           op(this)
        }
    }
}

typealias myType = (Int) -> Int

class LambdaPractice {}

fun <T> List<T>.myForEachIndex(params: (index: Int, T) -> Unit) {

    var index = 0

    for (element in this) {

        params(index, element)

        index++
    }
}