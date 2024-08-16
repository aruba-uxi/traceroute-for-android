package com.wandroid.traceroute.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import com.wandroid.traceroute.TraceRoute

class MainActivity : AppCompatActivity() {

    private lateinit var text: AppCompatEditText
    private lateinit var result: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.sample_text)
        result = findViewById(R.id.result)

        findViewById<AppCompatButton>(R.id.sample_button).setOnClickListener {
            doTraceRoute()
        }
    }

    private fun doTraceRoute() {
        result.text = ""
        
        // Retrieve user input and split it into an array of arguments
        val userInput = text.text.toString()
        val userArgs = userInput.split("\\s+".toRegex()).toTypedArray()
        
        TraceRoute.setCallback {
            success { result.append("\ntraceroute finish") }
            update { text -> result.append(text) }
            failed { code, reason -> result.append("\ntraceroute failed. Code: $code, Reason: $reason") }
        }
        
        // Pass the parsed arguments to the traceRoute method
        TraceRoute.traceRoute(userArgs, true)
    }
}
