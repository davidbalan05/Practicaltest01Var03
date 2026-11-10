package ro.pub.cs.systems.eim.practicaltest01var03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var03SecondaryActivity : AppCompatActivity() {
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var textView2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_secondary)

        val button4 = findViewById(R.id.button4) as Button
        val button5 = findViewById(R.id.button5) as Button
        textView2 = findViewById(R.id.textView2)

        if (intent != null && intent.hasExtra("1")) {
            textView2.setText(intent.getStringExtra("1"))
        }

        button4.setOnClickListener {
            setResult(RESULT_OK, Intent())
            finish()
        }

        button5.setOnClickListener {
            setResult(RESULT_CANCELED, Intent())
            finish()
        }

    }
}