package com.guanhong.lambdapractice

val stringList = listOf("a", "b", "c")
val listLambda = { element: String -> Unit

    println(element)
}

fun <GuanHong> List<GuanHong>.GuanHongForEach(_: (GuanHong) -> Unit){

    for (element in this) {
        println(element)
    }
}

fun begin() {

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

    stringList.forEach(::println)
}