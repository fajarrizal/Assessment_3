package com.example.assessment_3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.assessment_3.f_dialog_bottom_sheet.F_dialog_bottom_sheet_s2000
import com.ncorti.slidetoact.SlideToActView

class F_show_image : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view = inflater.inflate(R.layout.fragment_f_show_image, container, false)


        val imageList = ArrayList<SlideModel>() // Create image list

        imageList.add(SlideModel("https://images.unsplash.com/photo-1616634375264-2d2e17736a36?q=80&w=2069&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "Honda S2000 is an iconic car."))
        imageList.add(SlideModel("https://images.unsplash.com/photo-1696356633775-3232991a3ebb?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", "The S2000 is from Japan."))

        val imageSlider = view.findViewById<ImageSlider>(R.id.imageslider)
        imageSlider.setImageList(imageList)
        imageSlider.startSliding(3000)


        val slideToActView : SlideToActView = view.findViewById(R.id.btn_slide_act_detail)


        slideToActView.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener{
            override fun onSlideComplete(view: SlideToActView) {
                // Show the Bottom Sheet when the sliding action is complete
                val bottomSheetFragment = F_dialog_bottom_sheet_s2000()
                val transaction = childFragmentManager.beginTransaction()
                transaction.add(bottomSheetFragment, bottomSheetFragment.tag)
                transaction.commit()
                Log.d("Transaction", "Fragment transaction committed")
            }
        }

        return view
    }


}