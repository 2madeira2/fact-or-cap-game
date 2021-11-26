package com.tmvlg.factorcapgame.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tmvlg.factorcapgame.R
import com.tmvlg.factorcapgame.ui.menu.MenuFragment
import com.tmvlg.factorcapgame.ui.menu.MenuViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set MenuFragment as first
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, MenuFragment())
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        }
        // uncomment to close your app on back button pressed
//        else {
//            super.onBackPressed()
//        }
    }
}
