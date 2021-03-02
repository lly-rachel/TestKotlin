package com.example.testkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

class MsgAdapter (val msgList : List<Msg>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class LeftViewHolder(view : View):RecyclerView.ViewHolder(view){
        val leftMsg : TextView = view.findViewById(R.id.left_msg_tv)
    }

    inner class RightViewHolder(view : View):RecyclerView.ViewHolder(view){
        val rightMsg : TextView = view.findViewById(R.id.right_msg_tv)
    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(viewType == Msg.TYPE_RECEIVED){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item,parent,false)
            return LeftViewHolder(view)
        }else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item,parent,false)
            return RightViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg = msgList[position]
        when(holder){
            is LeftViewHolder -> holder.leftMsg.text = msg.content
            is RightViewHolder -> holder.rightMsg.text = msg.content
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount() = msgList.size

}