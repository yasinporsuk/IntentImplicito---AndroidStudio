package com.example.intentsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentsapp.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener {
            sendEmail()
        }
    }

    private fun sendEmail() {
        val recipient = binding.recipiente.text.toString()
        val message = binding.mensaje.text.toString()
        val subject = binding.asunto.text.toString()

        // Crear el URI mailto
        val emailUri = Uri.parse("mailto:${Uri.encode(recipient)}" +
                "?subject=${Uri.encode(subject)}" +
                "&body=${Uri.encode(message)}")

        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = emailUri
        }

        startActivity(emailIntent)
    }
}