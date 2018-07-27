package com.aptus.sample

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.SparseArray
import com.aptus.droidils.utils.AppShortCut
import com.aptus.droidils.utils.buildShortCuts

import kotlinx.android.synthetic.main.activity_main.*
import android.net.Uri
import com.aptus.droidils.utils.setShortCuts


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                val appShortCuts = SparseArray<AppShortCut>()
                val intents = arrayOf(Intent(Intent.ACTION_MAIN, Uri.EMPTY, this,
                        MainActivity::class.java)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK),
                        Intent("com.aptus.droidils.OPEN_SECOND"))
                // It's recommended more than 4 shortcut is not allowed
                appShortCuts.append(0, AppShortCut("0",
                        "Droidils 1", R.drawable.ic_notifications, intents))
                appShortCuts.append(1, AppShortCut("1",
                        "Droidils 2", R.drawable.ic_notifications, intents))
                appShortCuts.append(2, AppShortCut("2",
                        "Droidils 3", R.drawable.ic_notifications, intents,
                        "Simple utils library", true))
                setShortCuts(buildShortCuts(appShortCuts))
            }
        }
    }
}