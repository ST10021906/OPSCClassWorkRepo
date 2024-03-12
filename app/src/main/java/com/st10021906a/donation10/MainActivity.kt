package com.st10021906a.donation10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.get
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.snackbar.Snackbar
import com.st10021906a.donation10.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root);
        binding.amountPicker.minValue = 0;
        binding.amountPicker.maxValue = 1000;
        binding.progressBar.max = 10000;

        //var TotalAmount:Double =


            binding.Direct.setOnClickListener()
            {
                Toast.makeText (this, "YOu will be charged and aditional 3%", Toast.LENGTH_SHORT).show()
            }
            binding.PayPal.setOnClickListener()
            {
                Toast.makeText (this, "YOu will be charged and aditional 1.5%", Toast.LENGTH_SHORT).show()
            }

        binding.donateButton.setOnClickListener {
            goalCheck()
        }
        binding.fabEmail.setOnClickListener { view ->

            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val moveIntent= Intent(this,DonationDetailsActivity::class.java)
        binding.pageNav.setOnClickListener(){

                startActivity(moveIntent)}
    }

    fun goalCheck()
    {
        if(binding.progressBar.progress.toDouble() >= 10000.00)
        {
            Toast.makeText (this, "Target Excedded!", Toast.LENGTH_SHORT).show()
        }
        else
        {
            donateAmount(binding.progressBar.progress.toDouble())
        }
    }

    fun donateAmount(TotalAmount:Double)
    {
        var amountToDonate = binding.amountPicker.value
        var addAmount:Double
        var finAmount:Double = TotalAmount

        if(binding.PayPal.isChecked)
        {
            addAmount = amountToDonate * 0.03
             finAmount = TotalAmount + (addAmount + amountToDonate)
        }
        else if (binding.Direct.isChecked)
        {
            addAmount = amountToDonate * 0.015
            finAmount = TotalAmount + (addAmount + amountToDonate)
        }
        binding.progressBar.setProgress(finAmount.toInt(),true)
    }
}