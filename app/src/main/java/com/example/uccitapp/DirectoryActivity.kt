package com.example.uccitapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uccitapp.databinding.ActivityDirectoryBinding

class DirectoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDirectoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDirectoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val facultyList = listOf(
            FacultyMember(
                "Natalie Rose",
                "Dean, School of Mathematics & Information Technology",
                "(876) 906-3000 ext: 4046",
                "deanmst@ucc.edu.jm",
                R.drawable.natalie_rose
            ),
            FacultyMember(
                "Henry Osbourne",
                "Chief Information Officer",
                "(876) 906-3000 ext: 4044",
                "ithod@ucc.edu.jm",
                R.drawable.henry_osbourne
            ),
            FacultyMember(
                "Otis Osbourne",
                "Head of Department",
                "(876) 906-3000 ext: 4045",
                "itfaculty@ucc.edu.jm",
                R.drawable.otis_osbourne
            )
        )

        val adapter = FacultyAdapter(facultyList) { phone, email ->
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            startActivity(Intent.createChooser(phoneIntent, "Choose an app to call"))
            startActivity(Intent.createChooser(emailIntent, "Choose an app to email"))
        }

        binding.recyclerView.adapter = adapter
    }
}

data class FacultyMember(
    val name: String,
    val role: String,
    val phone: String,
    val email: String,
    val imageResId: Int
)
