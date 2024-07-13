package com.example.uccitapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SocialMediaPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val pageTitles = listOf("Facebook", "X", "Instagram", "TikTok")
    private val pageUrls = listOf(
        "https://www.facebook.com/uccjamaica/",
        "https://x.com/UCCjamaica",
        "https://www.instagram.com/uccjamaica/",
        "https://www.tiktok.com/@uccjamaica"
    )

    fun getPageTitles(): List<String> {
        return pageTitles
    }

    override fun createFragment(position: Int): Fragment {
        return SocialMediaFragment.newInstance(pageUrls[position])
    }

    override fun getItemCount(): Int {
        return pageTitles.size
    }
}