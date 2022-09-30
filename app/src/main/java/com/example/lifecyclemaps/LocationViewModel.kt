package com.example.lifecyclemaps


import androidx.lifecycle.ViewModel

// You'll find these imports useful for the network communication and JSON parsing
import org.json.JSONObject
import java.net.URL

data class LatLon(var lat: Double=0.0, var lon: Double=0.0)

class LocationViewModel : ViewModel(){
    // Create a latLon property (of type LatLon) and corresponding LiveData, as last week

    // Write a method to search for a given place by name
    // This should use a coroutine and:
    // - call https://hikar.org/webapp/map/search?q=<the name the user entered>
    // - parse the JSON returned. It's one object containing "lat" and "lon" fields
    // - set the latLon property to be a LatLon object containing the data from the JSON
}