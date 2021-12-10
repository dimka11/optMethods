package com.ds.optm

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.cos


object Solution {
    private val reader = BufferedReader(InputStreamReader(System.`in`))
    private var a = -5.0
    private var b = 5.0
    private var eps = 0.00001
    @JvmStatic
    fun main(args: Array<String>) {
        val type = 0
        try {
            println("Введите eps (точность)")
            eps = reader.readLine().toDouble()
//            println("Введите 0 для поиска мин или 1 для макс")
//            type = reader.readLine().toInt()
            println("Введите начало отрезка")
            a = reader.readLine().toDouble()
            println("Введите конец отрезка")
            b = reader.readLine().toDouble()
        } catch (e: Exception) {
//            println("Что-то пошло не так")
//            return
        }
        var c = getCenter(a, b)
        var f2 = 0.0
        var f1 = 0.0
        println("a: $a")
        println("b: $b")
        println("\n")
        while (abs(b - a) > eps) {
            f2 = mathFunction(c + eps)
            f1 = mathFunction(c - eps)
            if (compare(type, f2, f1)) {
                b = c
            } else {
                a = c
            }
            c = getCenter(a, b)
            println("a: $a")
            println("b: $b")
            println("\n")
        }
        val res = getCenter(a, b)
        println("a: $a")
        println("b: $b")
        println("Точка минимума: $res")
        println("Значение функции в точке: " + mathFunction(res))
    }

    private fun mathFunction(x: Double): Double {
        return 2 * cos(x) + 6
    }

    private fun getCenter(a: Double, b: Double): Double {
        return (a + b) / 2
    }

    private fun compare(type: Int, f2: Double, f1: Double): Boolean {
        return if (type == 0) {
            f2.compareTo(f1) == 1
        } else {
            f2.compareTo(f1) != 1
        }
    }
}
