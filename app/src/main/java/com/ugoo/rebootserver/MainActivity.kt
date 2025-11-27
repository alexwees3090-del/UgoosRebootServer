package com.ugoo.rebootserver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var server: HttpServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        server = HttpServer(1111)
        server.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        server.stop()
    }
}
