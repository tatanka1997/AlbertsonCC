package com.example.albertsoncc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.albertsoncc.R
import com.example.albertsoncc.ui.frag.WordFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragmentID, WordFragment())
            .commit()
    }
}