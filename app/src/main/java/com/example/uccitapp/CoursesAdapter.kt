package com.example.uccitapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uccitapp.databinding.ItemCourseBinding

class CoursesAdapter(private val coursesList: MutableList<Course>) : RecyclerView.Adapter<CoursesAdapter.CourseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = coursesList[position]
        holder.bind(course)
    }

    override fun getItemCount() = coursesList.size

    class CourseViewHolder(private val binding: ItemCourseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(course: Course){
            binding.tvCourseCode.text = course.code
            binding.tvCourseName.text = course.name
            binding.tvCourseCredits.text = course.credits
            binding.tvCoursePrerequisites.text = course.prerequisites
            binding.tvCourseDescription.text = course.description
        }
    }
}
