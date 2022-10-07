package com.example.lifecyclemaps

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


class LocationEntryFrag : Fragment(R.layout.locationentryfrag) {
    var callback: ((String) -> Unit)? = null
    val viewModel : LocationViewModel by activityViewModels()

    // Implement onViewCreated() to:
    // - listen for button click events
    // - read the location the user entered
    // - send the location to the method in the ViewModel which calls the web API to
    //   find its lat/lon and updates the LiveData appropriately

    override fun onViewCreated(fragmentView: View, b: Bundle?) {



        val gobutton = fragmentView.findViewById<Button>(R.id.btnGo)

        gobutton.setOnClickListener {
            val ed2 = fragmentView.findViewById<EditText>(R.id.etPlace)
            val place = ed2.getText().toString()

            lifecycleScope.launch {
                viewModel.search(place)
            }







        }
    }
}