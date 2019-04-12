package com.example.ueyz2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_one_user.*

class OneUserActivity : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    private lateinit var userName:String
    private lateinit var userEmail:String
    private lateinit var ratingsMade:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_user)
        db= FirebaseFirestore.getInstance()
        val userId = intent.getStringExtra("userId")
        val userRef=db.collection("usuarios").document(userId)

        //Codigo que se utiliza para obtener la informacion del usuario que hizo logging
        userRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    userName=document["name"].toString()
                    userEmail=document["eMail"].toString()
                    ratingsMade=document["ratingsMade"].toString()

                    userNameShow.text=userName
                    emailShow.text = userEmail
                } else {
                    Toast.makeText(applicationContext,"Error1",Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(applicationContext,"Error2",Toast.LENGTH_SHORT).show()
            }
    }
}
