package com.francisco.juego

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.francisco.juego.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        CoroutineScope(Dispatchers.Default).launch {
//            var contador = 0
//            while (true){
//                withContext(Dispatchers.Main){
//                    binding.textShow.text = contador.toString()
//                    contador++
//                }
//                delay(1000)
//            }
//        }



        GlobalScope.launch {
            var contador = 0
            while (true) {
                withContext(Dispatchers.Main) {
                    binding.textShow.text = contador.toString()
                    contador++
                }
                delay(1000)
            }
        }



    }




}