package com.example.lifecyclemaps


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray

// You'll find these imports useful for the network communication and JSON parsing
import org.json.JSONObject
import java.net.URL

data class LatLon(var lat: Double=0.0, var lon: Double=0.0)

class LocationViewModel : ViewModel() {
    // Create a latLon property (of type LatLon) and corresponding LiveData, as last week

    // Write a method to search for a given place by name
    // This should use a coroutine and:
    // - call https://hikar.org/webapp/map/search?q=<the name the user entered>
    // - parse the JSON returned. It's one object containing "lat" and "lon" fields
    // - set the latLon property to be a LatLon object containing the data from the JSON

    var latLon = LatLon()
        set(newValue) {
            field = newValue
            liveLatLon.value = newValue
        }
    var liveLatLon = MutableLiveData<LatLon>()

    suspend fun search(place: String) {

        // Interact with UI in the foreground (read a search query)
        var searchQuery = ""

        // Switch to a background context to communicate with the web and with a
        // database. The foreground code suspends while waiting for the background code to complete
        withContext(Dispatchers.IO) {

            searchQuery =
                URL("https://hikar.org/webapp/map/search?q=$place").readText()// must be done in the background
//            saveToRoomDatabase(results) // must be done in the background

        }

        val jsonArray = JSONArray(searchQuery) // 'json' contains our JSON (see above)

// JSONArray.length() gives the number of elements inside the array
        for (i in 0 until jsonArray.length()) {
            // Get the JSON object at index i within the JSON array
            val curObject = jsonArray.getJSONObject(i)

            // Extract the individual fields of the current object with getString()
            val lat = curObject.getDouble("lat")
            val lon = curObject.getDouble("lon")
            // The foreground code resumes here
            // Update the UI with the data from the web
            latLon = LatLon(lat, lon)
        }

    }
}



//    lifecycleScope.launch {
//        var httpResponse = ""
//
//        // Switch to the IO context to perform the HTTP request
//        withContext(Dispatchers.IO) {
//            // Send a GET request to https://kotlinlang.org
//            httpResponse = URL("https://kotlinlang.org").readText()
//        }
//
//        // Add the response to a text view
//        findViewById<TextView>(R.id.tv1).text = httpResponse
//    }



