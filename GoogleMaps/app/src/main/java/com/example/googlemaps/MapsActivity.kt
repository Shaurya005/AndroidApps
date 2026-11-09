package com.example.googlemaps

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    val locationManager by lazy{
        getSystemService(Context.LOCATION_SERVICE) as  LocationManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

   /*
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        requestAccessFineLocation()
        super.onStart()
        when{
            isFineLocationGranted()->{
                setUpLocationListener()
            }
            else -> requestAccessFineLocation()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            999 ->  if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                        setUpLocationListener()
                    else
                        Toast.makeText(this,"Permission NOT Granted",Toast.LENGTH_LONG).show()
        }
    }
     */

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        requestAccessFineLocation()
        super.onStart()
        when{
            isFineLocationGranted()->{
                when{
                    isLocationEnabled() -> setUpLocationListener()
                    else -> showGPSNotEnabledDialog()
                }
            }
            else -> requestAccessFineLocation()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            999 ->  if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                when{
                    isLocationEnabled() -> setUpLocationListener()
                    else -> showGPSNotEnabledDialog()
                }
            else
                Toast.makeText(this,"Permission NOT Granted",Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("MissingPermission")
    private fun setUpLocationListener(){
       // val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val providers=locationManager.getProviders(true)

        var l: Location?=null
        for(i in providers.indices.reversed()){
            l = locationManager.getLastKnownLocation(providers[i])
            if(l!=null) break;
        }
        l?.let {
            if(::mMap.isInitialized){
                val current = LatLng(it.latitude, it.longitude)
                mMap.addMarker(MarkerOptions().position(current).title("Marker in Current"))
                mMap.moveCamera(CameraUpdateFactory.newLatLng(current))
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isFineLocationGranted():Boolean{
        return checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestAccessFineLocation() {
        this.requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),999
        )
    }

    fun isLocationEnabled():Boolean{
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    fun showGPSNotEnabledDialog(){
        AlertDialog.Builder(this)
                .setTitle("Enable GPS")
                .setMessage("GPS is required for Google Maps")
                .setCancelable(false)
                .setPositiveButton("Enable Now"){ dialogInterface: DialogInterface, i: Int ->
                startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                dialogInterface.dismiss()
                }.show()
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.apply {
            isZoomControlsEnabled = true;
            isZoomGesturesEnabled = true;
            isMyLocationButtonEnabled = true;
            isCompassEnabled = true;
        }
        mMap.setMaxZoomPreference(20f)
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(25.3176, 82.9739)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Varanasi"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.addPolyline(PolylineOptions().
                        add(sydney,LatLng(20.56,99.893)).
                        color(ContextCompat.getColor(baseContext,R.color.design_default_color_primary ))
        ).width=2f;
    }
}