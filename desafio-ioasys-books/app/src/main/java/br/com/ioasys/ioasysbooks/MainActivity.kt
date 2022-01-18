package br.com.ioasys.ioasysbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var errorMessage = findViewById<AppCompatTextView>(R.id.errorMessage)
        val enterButton = findViewById<MaterialButton>(R.id.btnEnterButton)

        enterButton.setOnClickListener {
            errorMessage.visibility = View.VISIBLE
        }
    }
}