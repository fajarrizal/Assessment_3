package com.example.assessment_3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.assessment_3.f_dialog_bottom_sheet.F_dialog_bottom_sheet_evo5
import com.example.assessment_3.f_dialog_bottom_sheet.F_dialog_bottom_sheet_s2000
import com.ncorti.slidetoact.SlideToActView


class F_bottom_sheet : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_f_bottom_sheet, container, false)


        val imageList = ArrayList<SlideModel>() // Create image list

        imageList.add(SlideModel("https://i0.wp.com/i.redd.it/j2sm9dfjeyl31.jpg?resize=1200%2C800&ssl=1", "Lancer Evo 5 is a legendary performance sedan."))
        imageList.add(SlideModel("https://img.gta5-mods.com/q95/images/mitsubishi-lancer-evolution-v-rally-97/ff3dbf-20190102205514_1.jpg", "high-performance vehicles with rally DNA."))

        val imageSlider = view.findViewById<ImageSlider>(R.id.imageslider)
        imageSlider.setImageList(imageList)
        imageSlider.startSliding(3000)


        val slideToActView : SlideToActView = view.findViewById(R.id.btn_slide_act_detail)


        slideToActView.onSlideCompleteListener = object : SlideToActView.OnSlideCompleteListener{
            override fun onSlideComplete(view: SlideToActView) {
                // Show the Bottom Sheet when the sliding action is complete
                val bottomSheetFragment = F_dialog_bottom_sheet_evo5()
                val transaction = childFragmentManager.beginTransaction()
                transaction.add(bottomSheetFragment, bottomSheetFragment.tag)
                transaction.commit()
                Log.d("Transaction", "Fragment transaction committed")
            }
        }

        return view
    }

}