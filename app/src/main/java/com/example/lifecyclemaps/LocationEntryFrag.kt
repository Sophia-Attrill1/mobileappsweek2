package com.example.lifecyclemaps

import androidx.fragment.app.Fragment


class LocationEntryFrag : Fragment(R.layout.locationentryfrag) {

    // Implement onViewCreated() to:
    // - listen for button click events
    // - read the location the user entered
    // - send the location to the method in the ViewModel which calls the web API to
    //   find its lat/lon and updates the LiveData appropriately
}