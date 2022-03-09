package com.example.newreciclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newreciclerview.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
   // private var viewModel:UserViewModel = UserViewModel()

    private lateinit var binding:ActivityMainBinding
    lateinit var userList : MutableList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Firebase.firestore
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapter = RvAdapter(mutableListOf())
        binding.rvList.adapter = adapter
        binding.rvList.layoutManager = LinearLayoutManager(this)
        var list = mutableListOf<User>()
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {

                    var user = User(document.data!!["first"] as String,document.data!!["last"] as String, 0)
                    list.add(user)

                }
                adapter.aaa(list)
            }
            .addOnFailureListener { exception ->
                println("!!!"+exception.message)
            }




    }

}
