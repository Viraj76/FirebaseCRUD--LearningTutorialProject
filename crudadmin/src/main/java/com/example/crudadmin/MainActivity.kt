package com.example.crudadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crudadmin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainUpload.setOnClickListener {
            val intent = Intent(this,UploadActivity::class.java)
            startActivity(intent)

        }

        binding.mainUpdate.setOnClickListener {
            val intent = Intent(this,UpdateActivity::class.java)
            startActivity(intent)
        }

        binding.mainDelete.setOnClickListener {
            val intent = Intent(this,DeleteActivity::class.java)
            startActivity(intent)
        }

        binding.mainRead.setOnClickListener {
            val intent = Intent(this,ReadActivity::class.java)
            startActivity(intent)
        }


    }
}