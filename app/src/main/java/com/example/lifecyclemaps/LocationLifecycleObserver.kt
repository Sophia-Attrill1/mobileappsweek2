package com.example.lifecyclemaps

import android.content.Context
import android.location.LocationManager
import androidx.lifecycle.DefaultLifecycleObserver


class LocationLifecycleObserver(val ctx: Context, val vm: LocationViewModel) : DefaultLifecycleObserver {

    lateinit var locationManager: LocationManager
    var gpsPermission = false // has GPS permission been obtained yet?

    // Initialise your LocationManager in onCreate()

    // Start requesting updates in onResume(), if GPS permission has been granted

    // Remove updates (locationManager.removeUpdates(this)) in onPause(), if GPS permission has been granted

    // Implement onLocationChanged() to update the LatLon in the ViewModel,
    // plus the other methods of LocationListener
}