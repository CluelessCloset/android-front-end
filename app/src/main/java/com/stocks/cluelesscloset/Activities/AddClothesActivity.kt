package com.stocks.cluelesscloset.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.stocks.cluelesscloset.R
import kotlinx.android.synthetic.main.activity_add_clothes.*

class AddClothesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_clothes)

        accessories_card.setOnClickListener {
            
        }

        tops_card.setOnClickListener {

        }

        bottoms_card.setOnClickListener {

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
}
