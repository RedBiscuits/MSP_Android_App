package com.example.msp_app.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import android.os.Bundle
import android.widget.Toast
import com.example.msp_app.R
import com.example.msp_app.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    //BottomNavigationView bottomNavigationView;
    val faceBookUri = "https://www.facebook.com/ASUTC"
    val youtubeUri = "https://www.youtube.com/channel/UCx4RR5PPCwfU_Om_9pAwaCA/featured"
    val linedInUri = "https://www.linkedin.com/company/msp-tech-club-asu/"

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.hide()


        binding.bottomNavigation.setOnNavigationItemSelectedListener() { item ->
            when(item.itemId) {
                R.id.page_1 -> {

                    true
                }
                R.id.page_2 -> {
                    loadMainFragment()
                    Toast.makeText(this , "hello from 2" , Toast.LENGTH_LONG).show()
                    true
                }
                R.id.page_3 -> {
                    Toast.makeText(this , "hello from 3" , Toast.LENGTH_LONG).show()
                    true
                }

                else -> false
            }
        }
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.page_2; // change to whichever id should be default
        }

    }

    private fun loadMainFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view, Committees())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}