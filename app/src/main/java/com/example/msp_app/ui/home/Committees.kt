package com.example.msp_app.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.msp_app.R
import com.example.msp_app.databinding.FragmentCommitteesBinding
import com.smarteist.autoimageslider.SliderAnimations


class Committees : Fragment(R.layout.fragment_committees) {

    private val eventsAdapter:TrendingListAdapter = TrendingListAdapter()
    private lateinit var binding:FragmentCommitteesBinding
    lateinit var sliderAdapter:ImageSliderAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommitteesBinding.inflate(layoutInflater , container , false)
        val images = ArrayList<Int>()
        images.add(R.drawable.crew_home)
        images.add(R.drawable.cyber)
        images.add(R.drawable.datascience)
        images.add(R.drawable.datascience)

        Log.d("meoww" , "hello from commi teez")

        sliderAdapter = ImageSliderAdapter(images)
        binding.imageSlider.setSliderAdapter(sliderAdapter)
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        binding.imageSlider.startAutoCycle()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}