package com.guanhong.lambdapractice

fun demo() {
    val a: Int = 1
    val b: Int = 2


    val add = { inputA: Int, inputB: Int -> inputA + inputB }
    val inc5 = { input: Int -> input + 5 }
    val square = { input: Int -> input * input }


    // pass fun as parameter: (outside fun)
    println(inc1(a))
    println(inc1(inc2(a)))

    // pass fun as parameter: (use variable to represent a fun)
    println(add(a, b))
    println(inc5(a))

    // extension demo
    println(a.inc3().inc4())


    // functional programming demo
    val composeA = inc5.andThen(square)
    val composeB = inc5 andThenInfix square
    val composeC = inc5 andThenTypeAlias square
    val composeD = inc5 andThenGeneric square

    printInputOutput(a, composeA)
    printInputOutput(a, composeB)
    printInputOutput(a, composeC)
    printInputOutput(a, composeD)

    printInputOutput(a, inc5 andThenGeneric square)


    // Generic demo
    // Double
    val c: Double = 1.0
    val incDouble = { input: Double -> input + 5 }
    val squareDouble = { input: Double -> input * input }

    printInputOutputGeneric(c, incDouble andThenGeneric squareDouble)
}

// fun
fun inc1(a: Int) = a + 1
fun inc2(a: Int) = a + 2

// extension
fun Int.inc3() = this + 3
fun Int.inc4() = this + 4


// Demo print (pass fun as parameter)
fun printInputOutput(a: Int, op: ((Int) -> Int)) {
    println("a = $a")
    println("op(a) = ${op(a)}")
}


fun ((Int) -> Int).andThen(op: ((Int) -> Int)): ((Int) -> Int) {
    return {
        op(this(it))
    }
}

infix fun ((Int) -> Int).andThenInfix(op: ((Int) -> Int)): ((Int) -> Int) {
    return {
        op(this(it))
    }
}



// typeAlias
typealias IntOp = ((Int) -> Int)

infix fun IntOp.andThenTypeAlias(op: IntOp): IntOp {
    return {
        op(this(it))
    }
}


// Generic
typealias Op<T> = (T) -> T

infix fun <T> Op<T>.andThenGeneric(op: Op<T>): Op<T> {
    return {
        op(this(it))
    }
}


// Demo Generic print (pass fun as parameter)
fun <T> printInputOutputGeneric(a: T, op: Op<T>) {
    println("a = $a")
    println("op(a) = ${op(a)}")
}