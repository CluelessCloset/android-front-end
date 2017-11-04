package com.stocks.cluelesscloset.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import com.stocks.cluelesscloset.Adapters.NewClothingAdapter
import com.stocks.cluelesscloset.POKO.ClothingData
import com.stocks.cluelesscloset.R
import kotlinx.android.synthetic.main.activity_add_clothes.*

/**
 * Activity that shows the user their inventoried items and allows them to add more if they'd
 * like to.
 */
class AddClothesActivity : AppCompatActivity() {
    /**
     * Adapter to hold user accessories.
     */
    var accessoriesAdapter: NewClothingAdapter? = null
    /**
     * Adapter to hold user tops.
     */
    var topAdapter: NewClothingAdapter? = null
    /**
     * Adapter to hold user bottoms.
     */
    var bottomAdapter: NewClothingAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_clothes)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        accessoriesAdapter = NewClothingAdapter(mutableListOf(
                ClothingData("https://t5.rbxcdn.com/5c05e86bc99e8e3923c1f915636fb43a", "Pizza doge"),
                ClothingData("http://ratemyprofessors.mtvnimages.com/prof/t_William_Moloney_47964.gif", "The savior")), applicationContext)

        accessories_list.layoutManager = LinearLayoutManager(applicationContext)
        accessories_list.adapter = accessoriesAdapter

        topAdapter = NewClothingAdapter(mutableListOf(
                ClothingData("http://clipart-library.com/img/1209343.jpg", "my boi"),
                ClothingData("http://i0.kym-cdn.com/entries/icons/original/000/013/564/doge.jpg", "doge")), applicationContext)

        tops_list.layoutManager = LinearLayoutManager(applicationContext)
        tops_list.adapter = topAdapter

        bottomAdapter = NewClothingAdapter(mutableListOf(
                ClothingData("http://darrienglasser.com/images/me.jpg", "lord"),
                ClothingData("https://avatars.githubusercontent.com/u/15134885?v=3?type=square", "peasant")), applicationContext)

        bottoms_list.layoutManager = LinearLayoutManager(applicationContext)
        bottoms_list.adapter = bottomAdapter

        accessories_card.setOnClickListener {
            if (accessories_list.visibility == GONE) {
                accessories_list.visibility = VISIBLE
                rotateAnimationUtils(accessories_arrow, true)
            } else {
                accessories_list.visibility = GONE
                rotateAnimationUtils(accessories_arrow, false)
            }
        }

        tops_card.setOnClickListener {
            if (tops_list.visibility == GONE) {
                tops_list.visibility = VISIBLE
                rotateAnimationUtils(tops_arrow, true)
            } else {
                tops_list.visibility = GONE
                rotateAnimationUtils(tops_arrow, false)
            }
        }

        bottoms_card.setOnClickListener {
            if (bottoms_list.visibility == GONE) {
                bottoms_list.visibility = VISIBLE
                rotateAnimationUtils(bottoms_arrow, true)
            } else {
                bottoms_list.visibility = GONE
                rotateAnimationUtils(bottoms_arrow, false)
            }

        }

        add_accessories.setOnClickListener {
            startActivity(Intent(this, NewClothesActivity::class.java))
        }

        add_tops.setOnClickListener {
            startActivity(Intent(this, NewClothesActivity::class.java))
        }

        add_bottoms.setOnClickListener {
            startActivity(Intent(this, NewClothesActivity::class.java))
        }
    }

    /**
     * Helper method: Allows for quickly animating the rotation arrow.
     * @param view View to rotate.
     * @param reset Boolean to determine if the view needs to be reset or not.
     */
    private fun rotateAnimationUtils(view: ImageView, reset: Boolean) {
        if (reset) {
            view.rotation = 0f
            view.animate().rotationBy(90f).setDuration(150).start()
        } else {
            view.rotation = 90f
            view.animate().rotationBy(-90f).setDuration(150).start()
        }

    }
}
