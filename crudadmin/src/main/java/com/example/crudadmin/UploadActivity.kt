package com.example.crudadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.example.crudadmin.databinding.ActivityMainBinding
import com.example.crudadmin.databinding.ActivityUploadBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    lateinit var  dataBaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val name = binding.uploadName.text.toString()
            val operator = binding.uploadOperator.text.toString()
            val location = binding.uploadLocation.text.toString()
            val phone = binding.uploadPhone.text.toString()

            dataBaseReference = FirebaseDatabase.getInstance().getReference("Users")

            val users = UsersData(name,operator,location,phone)

            dataBaseReference
                .child(phone)
                .setValue(users)
                .addOnSuccessListener {

                    binding.uploadName.text.clear()
                    binding.uploadOperator.text.clear()
                    binding.uploadLocation.text.clear()
                    binding.uploadPhone.text.clear()

                    Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@UploadActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener{
                    Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
                }
        }
    }
}