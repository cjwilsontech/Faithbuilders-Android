package com.eusebeia.faithbuilders


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 */
class SpeakersFragment : Fragment(), SpeakersAdapter.ClickHandler {
	
	override fun onResume() {
		super.onResume()
		// Set title
		activity?.setTitle(R.string.label_speakers)
	}
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		val view = inflater.inflate(R.layout.fragment_speakers, container, false)
		populateListView(view)
		return view
	}
	
	override fun onItemClicked(position: Int) {
		val newFragment = BiographyFragment()
		newFragment.show(fragmentManager, "biography")
		val bundle = Bundle()
		bundle.putInt("SpeakerIndex", position)
		newFragment.arguments = bundle
	}
	
	private fun populateListView(view: View) {
		val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewSpeakers)
		val layoutManager = LinearLayoutManager(view.context)
		recyclerView.layoutManager = layoutManager
		recyclerView.adapter = SpeakersAdapter(this)
		recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, layoutManager.orientation))
	}
}
