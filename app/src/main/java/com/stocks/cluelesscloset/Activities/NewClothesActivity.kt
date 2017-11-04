package com.stocks.cluelesscloset.Activities

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.stocks.cluelesscloset.R
import kotlinx.android.synthetic.main.activity_new_clothes.*
import java.io.File




/**
 * Activity designated for user when they want to add a new article of clothing.
 */
class NewClothesActivity : AppCompatActivity() {
    private val CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1034
    private val CODE_ALL = 5

    private val APP_TAG = "New Clothes Activity"

    private var photoFile: File? = null
    private var photoFileName: String = "photo_file.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_clothes)
        gibePermission()

        val directory = File(Environment.getExternalStorageDirectory().toString() + File.separator + "images")
        directory.mkdirs()

        photo_button.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            // Create a File reference to access to future access
            photoFile = getPhotoFileUri(photoFileName)

            // wrap File object into a content provider
            // required for API >= 24
            // See https://guides.codepath.com/android/Sharing-Content-with-Intents#sharing-files-with-api-24-or-higher
            val fileProvider = FileProvider.getUriForFile(this, "com.stocks.fileprovider", photoFile)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)

            // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
            // So as long as the result is not null, it's safe to use the intent.
            if (intent.resolveActivity(packageManager) != null) {
                // Start the image capture intent to take photo
                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE)
            }


        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // by this point we have the camera photo on disk
                photoFile?.let {
                    val takenImage = BitmapFactory.decodeFile(it.toString())
                    // RESIZE BITMAP, see section below
                    // Load the taken image into a preview
                    val ivPreview = photo as ImageView
                    ivPreview.setImageBitmap(takenImage)
                }
            } else { // Result was a failure
                Toast.makeText(this, "Picture wasn't taken!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Returns the File for a photo stored on disk given the fileName
    fun getPhotoFileUri(fileName: String): File? {
        // Only continue if the SD Card is mounted
        if (isExternalStorageAvailable()) {
            // Get safe storage directory for photos
            // Use `getExternalFilesDir` on Context to access package-specific directories.
            // This way, we don't need to request external read/write runtime permissions.
            val mediaStorageDir = File(
                    getExternalFilesDir(Environment.DIRECTORY_PICTURES), APP_TAG)

            // Create the storage directory if it does not exist
            if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
                Log.d(APP_TAG, "failed to create directory")
            }

            // Return the file target for the photo based on filename

            return File(mediaStorageDir.getPath() + File.separator + fileName)
        }
        return null
    }

    // Returns true if external storage for photos is available
    private fun isExternalStorageAvailable(): Boolean {
        val state = Environment.getExternalStorageState()
        return state == Environment.MEDIA_MOUNTED
    }

    private fun gibePermission() {
        val permissionsArray = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        ActivityCompat.requestPermissions(
                this,
                permissionsArray,
                CODE_ALL
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        for (permission in grantResults) {
            if (permission != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(applicationContext, "We don't like your kind here", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}
