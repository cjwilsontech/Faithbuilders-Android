package com.eusebeia.faithbuilders

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.speaker_list_item.view.*

/**
 * Created by Curtis Wilson on 7/11/2018.
 */
class SpeakersAdapter(private val clickHandler: ClickHandler? = null) : RecyclerView.Adapter<SpeakersAdapter.ViewHolder>() {
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val inflator = LayoutInflater.from(parent.context)
		val speakerView = inflator.inflate(com.eusebeia.faithbuilders.R.layout.speaker_list_item, parent, false)
		return ViewHolder(speakerView, clickHandler)
	}
	
	override fun getItemCount(): Int {
		return MainActivity.SpeakerList.size
	}
	
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val speaker = MainActivity.SpeakerList[position]
		holder.locationTextView.text = speaker.location
		holder.nameTextView.text = speaker.name
		Glide.with(holder.speakerImageView).load(speaker.photo).into(holder.speakerImageView)
	}
	
	interface ClickHandler {
		fun onItemClicked(position: Int)
	}
	
	class ViewHolder(itemView: View, val clickHandler: ClickHandler?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
		val speakerImageView: ImageView = itemView.itemIcon
		val nameTextView: TextView = itemView.itemName
		val locationTextView: TextView = itemView.itemLocation
		
		init {
			itemView.setOnClickListener(this)
		}
		
		override fun onClick(p0: View?) {
			clickHandler?.onItemClicked(adapterPosition)
		}
	}
}
