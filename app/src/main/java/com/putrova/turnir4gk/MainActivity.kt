package com.putrova.turnir4gk

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainList = findViewById<ListView>(R.id.mainList)
        val mainArray = ArrayList<String>()
        val mainAdapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_spinner_item, mainArray)
        mainList.adapter = mainAdapter
        LoadTournamentsTask(application as MainApplication, mainArray, mainAdapter).execute()
    }

    private class LoadTournamentsTask(application: MainApplication, array: ArrayList<String>, adapter: ArrayAdapter<String>)
        : AsyncTask<Void, Void, Void>() {
        val application : MainApplication = application
        val array : ArrayList<String> = array
        val adapter : ArrayAdapter<String> = adapter

        override fun doInBackground(vararg params: Void?): Void? {
            for (tournament in application.database!!.tournaments().getAll()) {
                array.add(tournament.name)
            }
            adapter.notifyDataSetChanged()
            return null
        }
    }
}
