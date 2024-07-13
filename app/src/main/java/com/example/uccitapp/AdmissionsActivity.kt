package com.example.uccitapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uccitapp.databinding.ActivityAdmissionsBinding // importing the binding class

class AdmissionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdmissionsBinding // declaring the binding object

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdmissionsBinding.inflate(layoutInflater) // inflating the layout
        setContentView(binding.root)

    }
}