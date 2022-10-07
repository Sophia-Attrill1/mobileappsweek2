package com.example.lifecyclemaps

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.activity.viewModels



class LocationLifecycleObserver(val ctx: Context, val vm: LocationViewModel) : DefaultLifecycleObserver,
    LocationListener {



    lateinit var locationManager: LocationManager
    var gpsPermission = false // has GPS permission been obtained yet?

    // Initialise your LocationManager in onCreate()



    override fun onCreate(owner: LifecycleOwner){
        locationManager= ctx.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    // Start requesting updates in onResume(), if GPS permission has been granted

    override fun onResume(owner: LifecycleOwner){
        if (gpsPermission == true){

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, this)
        }
    }
    // Remove updates (locationManager.removeUpdates(this)) in onPause(), if GPS permission has been granted

    override fun onPause(owner: LifecycleOwner){
        locationManager.removeUpdates(this)
    }
    override fun onLocationChanged(location: Location){

            val latandLon = LatLon(location.latitude, location.longitude)
            vm.latLon = (latandLon)


    }

    // Implement onLocationChanged() to update the LatLon in the ViewModel,
    // plus the other methods of LocationListener

    override fun onProviderEnabled(provider: String){
        super.onProviderEnabled(provider)
    }

    override fun onProviderDisabled(provider: String){
        super.onProviderDisabled(provider)
    }


}