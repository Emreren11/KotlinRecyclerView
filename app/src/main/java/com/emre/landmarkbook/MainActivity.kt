package com.emre.landmarkbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.emre.landmarkbook.databinding.ActivityDetailsBinding
import com.emre.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList: ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Initialize - Tanımlama
        landmarkList = ArrayList<Landmark>()

        //Data
        val pisa = Landmark("Pisa", "Italy", R.drawable.pisa)
        val colosseum = Landmark("Colosseum", "Italy", R.drawable.colloseum)
        val eiffel = Landmark("Eiffel", "France", R.drawable.eyfel)
        val lBridge = Landmark("London Bridge", "UK", R.drawable.london)

        //Adding data to array - Arraya ekleme
        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(eiffel)
        landmarkList.add(lBridge)

        //val bitmap = Bitmap    //Görselleri tutmak için kullanılır

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val landmarkAdapter = LandmarkAdapter(landmarkList)
        binding.recyclerView.adapter = landmarkAdapter


/*
        //ListView
        //Adaptor : Layout <-> Data

        //Mapping - Veriyi başka bir veriye benzetme veya çevirme
        val adaptor = ArrayAdapter(this, android.R.layout.simple_list_item_1,landmarkList.map { landmark -> landmark.name })
        binding.listView.adapter = adaptor //Listview ile datayı bağlama

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            //position -> hangi satıra tıklandığını verir
            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
            intent.putExtra("landmark", landmarkList.get(position))
            startActivity(intent)
        }

 */
    }
}