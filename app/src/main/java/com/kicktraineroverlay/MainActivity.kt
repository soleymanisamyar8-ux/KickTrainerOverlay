package com.kicktraineroverlay

import android.app.Activity
import android.os.Bundle
import android.provider.Settings
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(30, 30, 30, 30)

        val title = TextView(this)
        title.text = "Kick Trainer Overlay\n\nابتدا اجازه نمایش روی برنامه‌ها را فعال کن."
        title.textSize = 18f

        val permission = Button(this)
        permission.text = "فعال کردن Overlay"

        permission.setOnClickListener {
            val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:$packageName")
            )
            startActivity(intent)
        }

        layout.addView(title)
        layout.addView(permission)

        setContentView(layout)
    }
}
