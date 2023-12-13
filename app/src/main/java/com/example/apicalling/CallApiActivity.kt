package com.example.apicalling

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicalling.databinding.ActivityCallApiBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CallApiActivity : AppCompatActivity() {
    lateinit var binding : ActivityCallApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {
        binding.btnClick.setOnClickListener {

            val Api = ApiObject.getInstance().create(ApiInterface::class.java)
            GlobalScope.launch {
                val result =Api.getData()
                if (result != null)
                // Checking the results
                    Log.d("data: ", result.toString())
                runOnUiThread {
                    var adapter = ApiAdapter(this@CallApiActivity,result, onItemclick = {
                        id: String, name: String, email: String, gender: String ,status: String->

                        var i = Intent(this@CallApiActivity,DisplayDataActivity::class.java)
                        i.putExtra("id",id)
                        i.putExtra("name",name)
                        i.putExtra("email",email)
                        i.putExtra("gender",gender)
                        i.putExtra("status",status)
                        startActivity(i)
                    })
                    var manager = LinearLayoutManager(this@CallApiActivity, RecyclerView.VERTICAL,false)
                    binding.rcv.adapter = adapter
                    binding.rcv.layoutManager = manager
                }
            }

//            var Procuteapi = ApiObject.getInstance().create(ApiInterface::class.java)
//            Log.e("TAG", "initview: "+Procuteapi)

//            // launching a new coroutine
//            GlobalScope.launch {
//
//
//                var result = Procuteapi.getData()
//                Log.e("TAG", "clicked: " )

//                if (result != null) {
//                    // Checking the results
//                    Log.e("TAG", "initview data: "+ result)
//                }

            }
        }

}