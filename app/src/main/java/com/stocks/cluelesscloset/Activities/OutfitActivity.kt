package com.stocks.cluelesscloset.Activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
import com.stocks.cluelesscloset.Fragments.SearchFragment
import com.stocks.cluelesscloset.R
import kotlinx.android.synthetic.main.activity_outfit.*


class OutfitActivity : AppCompatActivity(), GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private var apiClient: GoogleApiClient? = null
    private var currentLocation: Location? = null
    private val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1
    private val TAG = "OutfitActivity"
    val searchFragment: SearchFragment = SearchFragment()

    override fun onConnected(p0: Bundle?) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }

        currentLocation = LocationServices.FusedLocationApi.getLastLocation(apiClient)
        currentLocation?.let {
            Toast.makeText(this, "Latitude: ${it.latitude}, Longitude: ${it.longitude}", Toast.LENGTH_LONG).show()
            Log.wtf(TAG, "Latitude: ${it.latitude}, Longitude: ${it.longitude}")
            apiClient?.disconnect()
        }
    }

    override fun onConnectionSuspended(p0: Int) {
        Log.wtf(TAG, "pls dont suspend thank")
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.wtf(TAG, "This is why I cry every night")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildGoogleApiClient()
        apiClient?.connect()
        val permissionsArray = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
        ActivityCompat.requestPermissions(
                this,
                permissionsArray,
                PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
        )
        setContentView(R.layout.activity_outfit)
        searchFragment.searchCompleteListener = object : SearchFragment.SearchCompleteListener {
            override fun searchCompleted(s: String) {
                // send data to the CLOOOUD and ask for new outfit
                Toast.makeText(applicationContext, s, Toast.LENGTH_LONG).show()
            }
        }

        search_outfit_button.setOnClickListener {
            searchFragment.show(supportFragmentManager, "partay")
        }

       gib_new_outfit_button.setOnClickListener {
           TODO("IMPLEMENT THIS")
       }

        add_clothes_button.setOnClickListener {
            startActivity(Intent(this, AddClothesActivity::class.java))
        }
    }

    /**
     * Builds Google API client.
     */
    private fun buildGoogleApiClient() {
        apiClient = GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build()

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Yay we have permission, we can continue!", Toast.LENGTH_LONG).show()
                } else {
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                        Toast.makeText(this, "hi friend pls let us have location, thank", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "FINE DON'T USE OUR APP", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

}
