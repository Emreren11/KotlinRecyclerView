package com.emre.landmarkbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emre.landmarkbook.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //val intent = intent


        //casting
        //val selectedLandmark = intent.getSerializableExtra("landmark") as Landmark // as -> Landmark olarak geleceğini kesinleştirme

        val selectedLandmark = MySingleton.chosenLandmark
        selectedLandmark?.let {
            binding.nameText.text = it.name
            binding.countryText.text = it.country
            binding.imageView.setImageResource(it.image)
        }


    }
}