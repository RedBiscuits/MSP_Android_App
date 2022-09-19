package com.example.msp_app.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.msp_app.R
import com.example.msp_app.databinding.ActivityHomeBinding
import com.example.msp_app.ui.MSPViewModel
import com.example.msp_app.ui.event.Events

class HomeActivity : AppCompatActivity() {

    //BottomNavigationView bottomNavigationView;
    val faceBookUri = "https://www.facebook.com/ASUTC"
    val youtubeUri = "https://www.youtube.com/channel/UCx4RR5PPCwfU_Om_9pAwaCA/featured"
    val linedInUri = "https://www.linkedin.com/company/msp-tech-club-asu/"

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }
    private val viewModel by lazy {
        ViewModelProvider(this)[MSPViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar!!.hide()

        viewModel.getTrends()
        viewModel.getCommittees()
        viewModel.getAnimations()


        binding.bottomNavigation.setOnNavigationItemSelectedListener() { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    Toast.makeText(this , "hello from 1" , Toast.LENGTH_LONG).show()

                    true
                }
                R.id.page_2 -> {
                    transacteFramgent(Committees())
                    true
                }
                R.id.page_3 -> {
                    Toast.makeText(this , "hello from 3" , Toast.LENGTH_LONG).show()
                    true
                }
                R.id.page_4 -> {
                    transacteFramgent(Events())

                    true
                }
                else -> false
            }
        }
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.page_2; // change to whichever id should be default
        }

    }

    private fun transacteFramgent(fragment : Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}