package com.example.msp_app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.msp_app.R
import com.example.msp_app.databinding.FragmentCommitteesBinding
import com.example.msp_app.ui.MSPViewModel
import com.smarteist.autoimageslider.SliderAnimations


class Committees : Fragment(R.layout.fragment_committees){

    private lateinit var binding:FragmentCommitteesBinding
    private val viewModel:MSPViewModel by lazy {
        ViewModelProvider(this.requireActivity())[MSPViewModel::class.java]
    }
    private val sliderAdapter:ImageSliderAdapter = ImageSliderAdapter()
    private val adapter = CommiteesListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommitteesBinding.inflate(layoutInflater , container , false)

        viewModel.trendsMutableLiveData.observe(viewLifecycleOwner){
            sliderAdapter.setData(it)
            sliderAdapter.notifyDataSetChanged()
        }
        binding.imageSlider.setSliderAdapter(sliderAdapter)
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        binding.imageSlider.startAutoCycle()

        val animationsRecyclerView:RecyclerView = binding.committeeAnimationsRV
        animationsRecyclerView.layoutManager = StaggeredGridLayoutManager(
            2 , StaggeredGridLayoutManager.VERTICAL)


        viewModel.animationsMutableLiveData.observe(viewLifecycleOwner){
            adapter.setAnimationList(it)
        }
        animationsRecyclerView.adapter = adapter

        return binding.root
    }

}