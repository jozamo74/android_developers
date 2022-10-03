package com.example.myapp01

import android.app.Activity
import android.content.Context
import android.widget.Toast
import kotlin.coroutines.coroutineContext

/****
 * Project: My app01
 * From: com.example.myapp01
 * Created by José Zambrano Moya on 29/9/22 at 11:52
 * More info: zambranomoya74@gmail.com
 ****/

/*fun main() {
    test()
}*/

open class Person(name: String, age: Int)

class Developer(name: String, age: Int): Person(name, age)

abstract class Person2(name: String, val age: Int) {
    var name = name
        get() = "Name: $field"
        set(value) {
            field = value
        }
    /*private val name: String = name
    private val age: Int = age

    init {
        this.name = name
        this.age = age
    }*/
}

fun test(){
    var x: Any = 20
    x = "hola"
    println(x)

    val num = 20
    val y: Long = num.toLong()
    println(y)

    val p = Person("José", 47)
    val d = Developer("Paco", 60)

    val sum: (Int, Int) -> Int = {x, y -> x + y}
    val sum2 = {x: Int, y: Int -> x + y}
    
    val listOfInt = listOf(1, 2, 3, 15, 7, 6, 4)
    val result = listOfInt.filter { it % 2 == 0 }
        .map { it.toString() }
        .sorted()

    val mutable = mutableListOf(1,3,4,5)
    mutable.add(10)

    val empty =  emptyList<Int>()

    // No permite elementos repetidos
    val set = setOf(3,4,3,5,8)

    // "a" to 1 es función infix de Pair("b", 2)
    val map = mapOf("a" to 1, Pair("b", 2))
    for ((key, value) in map){
        println("clave: $key, valor: $value")
    }

    //Para no estar realizando copias de las listas cada vez que tiene que realizar una operación
    val result2 = listOfInt
        .asSequence()
        .filter { it % 2 == 0 }
        .map { it.toString() }
        .toList()

}

fun add(x: Int, y: Int): Int = x + y