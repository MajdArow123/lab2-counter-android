package com.example.cagbclab2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var count = 0      // current output value
    private var step = 1       // 1 = default behaviour, 2 = step behaviour

    private lateinit var tvOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvOutput = findViewById(R.id.tvOutput)
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSubtract: Button = findViewById(R.id.btnSubtract)
        val btnReset: Button = findViewById(R.id.btnReset)
        val btnStep: Button = findViewById(R.id.btnStep)

        updateOutput()

        btnAdd.setOnClickListener {
            count += step
            updateOutput()
        }

        btnSubtract.setOnClickListener {
            count -= step
            updateOutput()
        }

        btnReset.setOnClickListener {
            count = 0
            step = 1          // back to default behaviour
            updateOutput()
        }

        btnStep.setOnClickListener {
            step = 2          // now +/- change the value by two
        }
    }

    private fun updateOutput() {
        tvOutput.text = count.toString()
    }
}