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
}

fun add(x: Int, y: Int): Int = x + y