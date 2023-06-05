package com.example.fragmentapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPageAdapter(val fragment: ArrayList<Fragment>, fm: FragmentManager): FragmentStatePagerAdapter(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getCount(): Int {
        return fragment.size
    }

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }
}
