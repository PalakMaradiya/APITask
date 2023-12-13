package com.example.apicalling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apicalling.databinding.ActivityDisplayDataBinding

class DisplayDataActivity : AppCompatActivity() {
    lateinit var binding : ActivityDisplayDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDisplayDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()

    }

    private fun initview() {
        if(intent!=null)
        {
            var name = intent.getStringExtra("name").toString()
            var email = intent.getStringExtra("email").toString()
            var gender = intent.getStringExtra("gender").toString()
            var status = intent.getStringExtra("status").toString()


            binding.txtname.text = name
            binding.txtemail.text = email
            binding.txtgender.text = gender
            binding.txtstatus.text= status
        }
    }


}