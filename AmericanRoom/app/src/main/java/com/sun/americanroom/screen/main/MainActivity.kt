package com.sun.americanroom.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sun.americanroom.R
import com.sun.americanroom.screen.main.page.FirstFragment
import com.sun.americanroom.utils.addFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(FirstFragment.newInstance(),R.id.containerLayout)
    }
}
