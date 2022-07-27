package com.example.submission1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<ItemUser>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.addAll(listUsers)

        val rvUser = findViewById<RecyclerView>(R.id.list_user)
        rvUser.setHasFixedSize(true)

        val listAdapterUser = adapterUser(list)
        rvUser.adapter = listAdapterUser
        rvUser.layoutManager = LinearLayoutManager(this)

        listAdapterUser.setOnItemClickCallback(object : adapterUser.OnItemClickCallback{
            override fun onItemClicked(data: ItemUser) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra(DetailActivity.EXTRA_DATA, data)
                startActivity(intentToDetail)
            }
        })
    }

    private val listUsers: ArrayList<ItemUser>
    @SuppressLint("Recycle")
    get() {
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataFollower = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataRepository = resources.getStringArray(R.array.repository)

        val listuser = ArrayList<ItemUser>()
        for (i in dataName.indices){
            val itemUser = ItemUser(0,"","","","","","","")
            itemUser.avatar = dataAvatar.getResourceId(i, i)
            itemUser.username = dataUsername[i]
            itemUser.name = dataName[i]
            itemUser.location = dataLocation[i]
            itemUser.repository = dataRepository[i]
            itemUser.company = dataCompany[i]
            itemUser.followers = dataFollower[i]
            itemUser.following = dataFollowing[i]

            listuser.add(itemUser)
        }
        return listuser
    }
}