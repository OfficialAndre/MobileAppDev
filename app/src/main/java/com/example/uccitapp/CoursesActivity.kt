package com.example.uccitapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uccitapp.databinding.ActivityCoursesBinding
import com.google.firebase.firestore.FirebaseFirestore

class CoursesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoursesBinding
    private lateinit var coursesAdapter: CoursesAdapter
    private val coursesList = mutableListOf<Course>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewCourses.layoutManager = LinearLayoutManager(this)
        coursesAdapter = CoursesAdapter(coursesList)
        binding.recyclerViewCourses.adapter = coursesAdapter

        fetchCoursesFromFirestore()
    }

    private fun fetchCoursesFromFirestore() {
        val db= FirebaseFirestore.getInstance()
        db.collection("courses")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val course = document.toObject(Course::class.java)
                    coursesList.add(course)
                    coursesAdapter.notifyItemInserted(coursesList.size - 1) // Notify about new item
                }
                Log.d("CoursesActivity", "Courses fetched: $coursesList") // Log fetched courses
            }
            .addOnFailureListener { _ ->
                // error handling
            }
    }
}

data class Course(
    val code: String = "",
    val name: String = "",
    val credits: String = "",
    val prerequisites: String = "",
    val description: String = ""
)
