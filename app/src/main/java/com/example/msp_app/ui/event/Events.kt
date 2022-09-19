package com.example.msp_app.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.msp_app.R
import com.example.msp_app.ui.MSPViewModel
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView


class Events() : Fragment(R.layout.fragment_events) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: MSPViewModel by lazy {
            ViewModelProvider(this)[MSPViewModel::class.java]
        }
//        viewModel.getEvents()
//        var events = viewModel.eventsMutableLiveData.value
//        val view = inflater.inflate(R.layout.fragment_events, container, false)
//        val adapter = EventAdapter(events)
//        val svEvents = view.findViewById<SliderView>(R.id.sv_events)
//        svEvents.setSliderAdapter(adapter)
//        viewModel.eventsMutableLiveData.observe(viewLifecycleOwner){
//            events = it
//            adapter.setData(events)
//        }
//        svEvents.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
//        adapter.notifyDataSetChanged()

        return view
    }
}