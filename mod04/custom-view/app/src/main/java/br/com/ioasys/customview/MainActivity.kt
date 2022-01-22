package br.com.ioasys.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import br.com.ioasys.customview.databinding.ActivityMainBinding
import br.com.ioasys.customview.databinding.ResProfileImageBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        this.binding.followersIndicator.setCounter("5,000")
        this.binding.followersIndicator.setIndicator("Followers")
        this.binding.followersIndicator.setBold(true)
    }
}