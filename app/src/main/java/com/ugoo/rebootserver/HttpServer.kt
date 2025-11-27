package com.ugoo.rebootserver

import fi.iki.elonen.NanoHTTPD
import java.io.IOException

class HttpServer(port: Int) : NanoHTTPD(port) {

    override fun serve(session: IHTTPSession?): Response {
        val uri = session?.uri ?: "/"
        if (uri == "/reboot") {
            try {
                Runtime.getRuntime().exec(arrayOf("su", "-c", "reboot"))
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return newFixedLengthResponse("Rebooting device...")
        }
        return newFixedLengthResponse("OK")
    }
}
