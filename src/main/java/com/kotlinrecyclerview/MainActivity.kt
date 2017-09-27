package com.kotlinrecyclerview

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import com.kotlinrecyclerview.adapter.EmployeeAdapter
import com.kotlinrecyclerview.model.ItemModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView) as RecyclerView
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val users = ArrayList<ItemModel>()

        //adding some dummy data to the list
        users.add(ItemModel("Pranay Patel", "Android Geek"))
        users.add(ItemModel("Piyush Malaviya", "Android Geek"))
        users.add(ItemModel("Jaydip Prajapati", "Android Geek"))
        users.add(ItemModel("Pratik Patel", "Android Geek"))
        users.add(ItemModel("Wilson Christian", "Android Geek"))
        users.add(ItemModel("Mayank Dudhatra", "Android Geek"))
        users.add(ItemModel("Suraj Makhija", "Android Geek"))
        users.add(ItemModel("Jay Panera", "Android Geek"))
        users.add(ItemModel("Amit Sidhhpura", "Android Geek"))
        users.add(ItemModel("Maulik Hirani", "Android Geek"))

        val employeeAdapter = EmployeeAdapter(users) {
            Toast.makeText(this, it.name, Toast.LENGTH_LONG).show()
        }
        recyclerview.adapter = employeeAdapter
    }

}
