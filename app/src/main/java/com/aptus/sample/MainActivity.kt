@file:Suppress("UNUSED_ANONYMOUS_PARAMETER")

package com.aptus.sample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aptus.droidils.utils.onAfterTextChange
import com.aptus.droidils.utils.onBeforeTextChange
import com.aptus.droidils.utils.onTextChange
import com.aptus.droidils.utils.onTextWatcher
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TextWatcher listener all three methods
        imeActionEdit.onTextWatcher({ s, start, count, after -> },
                { s, start, before, count -> }, { s -> })

        // TextWatcher listener before text change
        imeActionEdit.onBeforeTextChange { s, start, count, after -> }

        // TextWatcher listener on text change
        imeActionEdit.onTextChange { s, start, before, count -> }

        // TextWatcher listener after text change
        imeActionEdit.onAfterTextChange { s -> }
    }
}