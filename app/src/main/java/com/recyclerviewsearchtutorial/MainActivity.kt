package com.recyclerviewsearchtutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.recyclerviewsearchtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Recycler View Search View
    lateinit var binding: ActivityMainBinding
    val user_list = listOf(
        User(1, "Mallangi"),
        User(2, "Paramesh"),
        User(3, "Reddy"),
        User(4, "Siva"),
        User(5, "Madhu"),
        User(6, "Ajay"),
        User(7, "Guru"),
        User(8, "Muddam"),
        User(9, "Narasimha"),
        User(10, "Sravani"),
        User(11, "Ramya"),
        User(12, "Loki"),
        User(13, "Surya"),
        User(14, "Naga"),
        User(15, "Raju"),
        User(16, "Harsha"),
        User(17, "Sindhu"),
        User(18, "Tharani"),
        User(19, "Sweety"),
        User(20, "Ravi"),
        User(1, "Rakesh")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.searchView.queryHint = "Search User ..."
        binding.searchView.setIconifiedByDefault(false)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.toString().isEmpty()) {
                    setRecyclerView(user_list)
                } else {
                    var filteredList = mutableListOf<User>()
                    for (user in user_list) {
                        if (user.name.lowercase().contains(newText.toString().lowercase())) {
                            filteredList.add(user)

                        }
                        setRecyclerView(filteredList)
                    }
                }
                return false
            }


        })
        /*
                binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        if (newText.toString().isEmpty()) {
                            setRecyclerView(user_list)
                        } else {
                            val filteredList = mutableListOf<User>()
                            for (user in user_list) {
                                if (user.name.lowercase().contains(newText.toString().lowercase())) {
                                    filteredList.add(user)
                                }
                            }
                            setRecyclerView(filteredList)

                        }
                        return false
                    }

                })
        */

        setRecyclerView(user_list)
    }

    private fun setRecyclerView(userList: List<User>) {
        binding.searchRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.searchRecyclerView.adapter = UserAdapter()
        (binding.searchRecyclerView.adapter as UserAdapter).submitList(userList)

    }
}