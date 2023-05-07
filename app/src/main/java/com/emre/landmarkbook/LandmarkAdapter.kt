package com.emre.landmarkbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emre.landmarkbook.databinding.RecyclerRowBinding

class LandmarkAdapter(val landmarkList: ArrayList<Landmark>): RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>() {

    class LandmarkHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        // viewholder ilk oluşturulduğunda ne yapılacak. Layout <-> Data bağlama
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandmarkHolder(binding)
    }

    override fun getItemCount(): Int {
        //Kaç adet oluşturalacak
        return landmarkList.size
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        //Bağlandıktan sonra ne olacak
        holder.binding.recyclerViewTextView.text = landmarkList.get(position).name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java) // COntext olarak tıklanılan itemview ın contextini verir
            //intent.putExtra("landmark", landmarkList.get(position))
            MySingleton.chosenLandmark = landmarkList.get(position)
            holder.itemView.context.startActivity(intent)
        }
    }
}