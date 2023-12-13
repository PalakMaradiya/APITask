package com.example.apicalling

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ApiAdapter(var callApiActivity: CallApiActivity, var result: List<ResponseapiItem>,var onItemclick:(String , String, String,String,String)->Unit) :
    RecyclerView.Adapter<ApiAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id: TextView = itemView.findViewById(R.id.txtid)
        var txtemail: TextView = itemView.findViewById(R.id.txtemail)
        var txtname: TextView = itemView.findViewById(R.id.txtname)
        var txtgender: TextView = itemView.findViewById(R.id.txtgender)
        var txtstatus: TextView = itemView.findViewById(R.id.txtstatus)
        var datacard: CardView = itemView.findViewById(R.id.datacard)

//        var imgavatar: ImageView = itemView.findViewById(R.id.imgavatar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var View = LayoutInflater.from(callApiActivity).inflate(R.layout.item_file, parent, false)
        return MyViewHolder(View)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.id.text = result.get(position).id.toString()
        holder.txtemail.text = result.get(position).email.toString()
        holder.txtname.text = result.get(position).name.toString()
        holder.txtgender.text = result.get(position).status.toString()
        holder.txtstatus.text = result.get(position).gender.toString()

//        holder.datacard.setOnClickListener {
//
//           onItemclick.invoke(
//               result[position].id!!,
//               result[position].name!!,
//               result[position].email!!,
//               result[position].gender!!,
//               result[position].status!!
//           )
//        }
        holder.datacard.setOnClickListener {
            onItemclick.invoke(
                result[position].id!!.toInt().toString(),
                result[position].name!!.toString(),
                result[position].email!!.toString(),
                result[position].gender!!.toString(),
                result[position].status!!.toString(),

            )
        }

        // holder.imgView
//        Glide.with(callApiActivity).load(result[position].avatar).into(holder.imgavatar)

    }


    override fun getItemCount(): Int {
        return result.size

    }
}
