package chat.application.assignment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ActionCodeEmailInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Settings : AppCompatActivity() {
    @SuppressLint("RestrictApi")
    private lateinit var curEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        curEmail = findViewById(R.id.email)

        supportActionBar?.apply {
            title="Settings"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val currentUser = intent.getParcelableExtra<FirebaseUser>("currentUser")
        curEmail.text = currentUser?.email

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun signOut(view: View){
        FirebaseAuth.getInstance().signOut()
        curEmail.text = ""
    }

}