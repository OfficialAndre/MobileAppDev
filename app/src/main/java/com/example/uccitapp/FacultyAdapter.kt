package com.example.uccitapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uccitapp.databinding.ItemFacultyBinding

class FacultyAdapter(
    private val facultyList: List<FacultyMember>,
    private val clickListener: (String, String) -> Unit
) : RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        val binding = ItemFacultyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FacultyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        val faculty = facultyList[position]
        holder.bind(faculty, clickListener)
    }

    override fun getItemCount() = facultyList.size

    class FacultyViewHolder(private val binding: ItemFacultyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(faculty: FacultyMember, clickListener: (String, String) -> Unit) {
            binding.imgFaculty.setImageResource(faculty.imageResId)
            binding.tvName.text = faculty.name
            binding.tvRole.text = faculty.role
            binding.tvPhone.text = faculty.phone
            binding.tvEmail.text = faculty.email

            binding.tvPhone.setOnClickListener {
                clickListener(faculty.phone, faculty.email)
            }

            binding.tvEmail.setOnClickListener {
                clickListener(faculty.phone, faculty.email)
            }
        }
    }
}
