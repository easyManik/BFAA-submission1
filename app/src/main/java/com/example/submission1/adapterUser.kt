package com.example.submission1

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class adapterUser(private val listUser: ArrayList<ItemUser>): RecyclerView.Adapter<adapterUser.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ItemUser)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var imgAvatar = itemView.findViewById<CircleImageView>(R.id.img_avatar)
            var tvName = itemView.findViewById<TextView>(R.id.tv_name)
            var tvLocation = itemView.findViewById<TextView>(R.id.tv_location)
            var tvCompany = itemView.findViewById<TextView>(R.id.tv_company)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int){
        val (avatar, name, company ,location ) = listUser[position]
        holder.imgAvatar.setImageResource(avatar)
        holder.tvName.text = name
        holder.tvCompany.text = company
        holder.tvLocation.text = location

        //clicked
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])}
    }

    override fun getItemCount(): Int = listUser.size
}
