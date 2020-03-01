package com.test.watersupply

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

internal class data_adaptor internal constructor(context: Context, private val resource: Int, private val itemList: ArrayList<String>?) : ArrayAdapter<data_adaptor.data_holder>(context, resource){

    override fun getCount(): Int {
        return if (this.itemList != null) this.itemList.size else 0
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView=convertView
        val holder : data_holder
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(resource, null)
            holder = data_holder()
            holder.date1 = convertView!!.findViewById(R.id.record_name)
            holder.time1 = convertView!!.findViewById(R.id.record_age)
            holder.press1 = convertView!!.findViewById(R.id.record_address)
            holder.temp1 = convertView!!.findViewById(R.id.record_position)
        }
        else{
            holder = convertView.tag as data_holder
        }

        holder.date1!!.setText("dffgdf")
        holder.time1!!.text= "aesrgdthfjg" //this.itemList!![position]
        holder.press1!!.text= "12345"  //this.itemList!![position]
        holder.temp1!!.text= "dfghbb" //this.itemList!![position]

        return convertView
    }

    internal class data_holder{
        var date1: TextView? = null
        var time1 : TextView? = null
        var temp1 : TextView? = null
        var press1 : TextView? = null
    }

    class  data(var date: String, var time: String, var temp :String, var press : String)
}