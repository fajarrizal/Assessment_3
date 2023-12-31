package com.example.assessment_3.f_viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.assessment_3.F_bottom_sheet
import com.example.assessment_3.F_show_image

class Fragment_page_adapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle

): FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {

        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            F_bottom_sheet()
        else
            F_show_image()
    }
}

