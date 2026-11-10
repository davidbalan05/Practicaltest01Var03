package ro.pub.cs.systems.eim.practicaltest01var03

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.savedstate.serialization.saved

class PracticalTest01Var03MainActivity : AppCompatActivity() {
    private val ANOTHER_ACTIVITY_REQUEST_CODE = 2017
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var editTextText: EditText
    private lateinit var editTextText2: EditText
    private lateinit var textView: TextView

    private val buttonClickListener = View.OnClickListener { view ->
        when (view.id) {
            R.id.button -> {
                try {
                    val text1 = editTextText.text.toString().toInt()
                    val text2 = editTextText2.text.toString().toInt()
                    val sum = text1 + text2

                    val text = text1.toString() + " + " + text2.toString() + " = " + sum.toString()
                    textView = findViewById(R.id.textView)
                    textView.setText(text)

                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Introduceti numere!", Toast.LENGTH_LONG).show()
                }
            }
            R.id.button2 -> {
                try {
                    val text1 = editTextText.text.toString().toInt()
                    val text2 = editTextText2.text.toString().toInt()
                    val dif = text1 - text2

                    val text = text1.toString() + " - " + text2.toString() + " = " + dif.toString()
                    textView = findViewById(R.id.textView)
                    textView.setText(text)

                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Introduceti numere!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    public override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        val text = findViewById(R.id.editTextText) as EditText
        val text2 = findViewById(R.id.editTextText2) as EditText
        savedInstanceState.putString("1", text.text.toString())
        savedInstanceState.putString("2", text2.text.toString())
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState.containsKey("1")) {
            editTextText.setText(savedInstanceState.getString("1"))
        }
        if (savedInstanceState.containsKey("2")) {
            editTextText2.setText(savedInstanceState.getString("2"))
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_main)

        findViewById<Button>(R.id.button).setOnClickListener(buttonClickListener)
        findViewById<Button>(R.id.button2).setOnClickListener(buttonClickListener)
        button3 = findViewById(R.id.button3)
        editTextText = findViewById(R.id.editTextText)
        editTextText2 = findViewById(R.id.editTextText2)
        textView = findViewById(R.id.textView)

        button3.setOnClickListener {
            val intent = Intent(this, PracticalTest01Var03SecondaryActivity::class.java)
            intent.putExtra("1", textView.text)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        when (requestCode) {
            ANOTHER_ACTIVITY_REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    val data = intent?.extras
                }
            }
            // process other request codes
        }
    }
}