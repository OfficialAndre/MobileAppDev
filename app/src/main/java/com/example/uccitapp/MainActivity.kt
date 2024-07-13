package com.example.uccitapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uccitapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDirectory.setOnClickListener {
            startActivity(Intent(this, DirectoryActivity::class.java))
        }
        binding.btnCourses.setOnClickListener {
            startActivity(Intent(this, CoursesActivity::class.java))
        }
        binding.btnAdmissions.setOnClickListener {
            startActivity(Intent(this, AdmissionsActivity::class.java))
        }
        binding.btnSocialMedia.setOnClickListener {
            startActivity(Intent(this, SocialMediaActivity::class.java))
        }
        binding.fabEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("email@example.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            intent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(intent, "Send Email"))
        }
    }
}
