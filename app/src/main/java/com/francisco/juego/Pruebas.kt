package com.francisco.juego

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    //Version uno
//    funcionLambda(3,4,{ result ->
//        println(result)
//    })
//
//    funcionLambda(12,45){
//        println(it)
//    }
//
//    println(hilo(4,3))

//    hiloLambda(3,4){
//        println(it)
//    }

    //coroutines()
    //dispachers()
    flow()
}
fun flow() {
    println("Flow")
    runBlocking {
        launch {
            crearSecuenciasFlow().collect {
                println("datos $it")
            }
        }
        launch {
            (1..10).forEach {
                delay(300)
                println("proceso dos")
            }
        }
    }
}
fun crearSecuenciasFlow(): Flow<Int> {
    return flow {
        (1..6).forEach {
            println("Emulando el procesamiento de datos")
            delay(2000)
            emit(it + Random.nextInt(20, 60))
        }
    }
}

//fun dispachers(){
//    println("Secuencias")
//    crearSecuencias().forEach {
//        println("$it datos regresados")
//    }
//}
//
//fun crearSecuencias() : Sequence<Int> {
//    return  sequence {
//        (1..6).forEach {
//            println("Elelemtos procesados")
//            Thread.sleep(2000)
//            yield(it+Random.nextInt(10,50))
//        }
//    }
//}

fun  coroutines(){}


//fun coroutines(){
//    runBlocking {
//        println("${Thread.currentThread().name}")
//        withContext(newSingleThreadContext("Nuevo contexto")){
//            delay(2000)
//            println("${Thread.currentThread().name}")
//        }
//    }
//}


//fun  coroutines(){
//    runBlocking {
//        launch {
//            println("Otro subproceso")
//        }
//        launch(Dispatchers.IO){
//            println("IO")
//        }
//
//    }
//}


//fun coroutines(){
//    runBlocking {
//        val job = launch {
//            println("inicia 1 ${Thread.currentThread().name}")
//            delay(6000)
//            println("Ejecutando instrucciones")
//            println("Termina 1 ${Thread.currentThread().name}")
//        }
//        launch {
//            while (true){
//                delay(1000)
//                println("Esta activo ${job.isActive}")
//                println("Esta cancelado ${job.isCancelled}")
//                println("Esta completo ${job.isCompleted}")
//                // codigo para temrinar
//                if((1..5).shuffled().first()==3) {
//                    println("Cancelar job")
//                    job.cancel()
//                }
//            }
//        }
//    }
//}

//fun coroutines(){
//    runBlocking {
//        val result = async {
//            println("Iniciando")
//            delay(2000)
//            println("Termina")
              //Regresa valor
//            "Resultado de datos"
//        }
//        println("Esperando resultado")
//        println("Resultado = ${result.await()}")
//    }
//}

//fun coroutines(){
//    //Este seguira ejecutando mientras main este vivo
//    GlobalScope.launch {
//        while (true){
//            println("Código de la rutina ${Thread.currentThread().name} ejecutando")
//        }
//    }
//}

//fun coroutines(){
      //Ejecuta esta rutina y se muere
//    runBlocking {
//        (1..1000000).forEach {
//            launch {
//                delay(1000)
//                print("*")
//            }
//        }
//    }
//}


//fun hiloLambda(a:Int,b:Int,callback:(result:Int)->Unit){
//    var result = 0
//    thread {
//        Thread.sleep(Random.nextLong(1000,3000))
//        result = a + b
//        callback(result)
//    }
//    println("Puedo ejecutar más líneas")
//}


//
//fun funcionLambda(a:Int,b:Int, callback:(result:Int)->Unit){
//    callback(a+b)
//}
//
//fun hilo(a:Int,b:Int):Int{
//    var result = 0;
//
//    thread {
//        Thread.sleep(Random.nextLong(1000,3000))
//        result = a + b
//    }
//
//    return  result
//}