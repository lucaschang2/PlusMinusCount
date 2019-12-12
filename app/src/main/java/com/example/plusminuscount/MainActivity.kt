package com.example.plusminuscount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Delare module-level variable
    private lateinit var countViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize the ViewModel
        countViewModel= ViewModelProviders.of(this).get(CountViewModel::class.java)

        //Add an observer to the viewModel
        countViewModel.count.observe(this, Observer {
            if(it.equals(4)) goodLuck() })
        TextViewCount.text = countViewModel.count.toString()

        buttonPlus.setOnClickListener{
            countViewModel.increment()
            TextViewCount.text=countViewModel.count.value.toString()
        }

        buttonMinus.setOnClickListener{
            countViewModel.decrement()
            TextViewCount.text=countViewModel.count.value.toString()
        }
    }

    private fun goodLuck() {
        Toast.makeText(applicationContext,"What a lucky day!",Toast.LENGTH_SHORT).show()
    }
}
