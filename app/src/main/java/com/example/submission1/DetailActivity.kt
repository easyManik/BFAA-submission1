package com.example.submission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.submission1.databinding.ActivityDetail2Binding

class DetailActivity : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "extra_data"
    }
    private lateinit var binding: ActivityDetail2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val data : ItemUser= intent.getParcelableExtra(EXTRA_DATA)!!

        binding.apply {
            dtlAvatar.setImageResource(data.avatar)
            dtlUsername.text = getString(R.string.username, data.username)
            dtlName.text = data.name
            dtlLocation.text = getString(R.string.location, data.location)
            dtlRepository.text = getString(R.string.repository, data.repository)
            dtlCompany.text = getString(R.string.company, data.company)
            dtlFollowers.text = getString(R.string.followers, data.followers)
            dtlFollowing.text = getString(R.string.following, data.following)
        }
    }
}