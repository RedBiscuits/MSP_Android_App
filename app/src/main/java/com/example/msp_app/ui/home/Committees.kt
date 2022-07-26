package com.example.msp_app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.etsy.android.grid.StaggeredGridView
import com.example.msp_app.R
import com.example.msp_app.databinding.FragmentCommitteesBinding
import com.example.msp_app.ui.MSPViewModel
import com.smarteist.autoimageslider.SliderAnimations


class Committees : Fragment(R.layout.fragment_committees),
    AdapterView.OnItemClickListener {

    private lateinit var binding:FragmentCommitteesBinding
    private lateinit var sliderAdapter:ImageSliderAdapter
    private var mGridView: StaggeredGridView? = null
    private var mAdapter: StaggeredAdapter? = null
    private var mData: ArrayList<String>? = null
    private val viewModel:MSPViewModel by lazy {
        ViewModelProvider(this)[MSPViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommitteesBinding.inflate(layoutInflater , container , false)
        viewModel.getTrends()
        var images: ArrayList<String> = viewModel.trendsMutableLiveData.value!!


        viewModel.trendsMutableLiveData.observe(viewLifecycleOwner){
            images = it
        }
        sliderAdapter = ImageSliderAdapter(images)
        binding.imageSlider.setSliderAdapter(sliderAdapter)
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        binding.imageSlider.startAutoCycle()
        mGridView = binding.gridView
        mAdapter = StaggeredAdapter(requireContext(), android.R.layout.simple_list_item_1, generateData())

        if (mData == null)
        {
            viewModel.getCommittees()
            mData = viewModel.committeesMutableLiveData.value
        }

        for (  data :String? in mData!!)
        {
            mAdapter!!.add(data)
        }

        mGridView!!.adapter = mAdapter
        mGridView!!.onItemClickListener = this
    
        return binding.root
    }


private fun generateData(): java.util.ArrayList<String> {
    val listData = ArrayList<String>()

    return listData
}


override fun onItemClick(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
    Toast.makeText(requireContext(), "Item Clicked: $position", Toast.LENGTH_SHORT).show()
}
}