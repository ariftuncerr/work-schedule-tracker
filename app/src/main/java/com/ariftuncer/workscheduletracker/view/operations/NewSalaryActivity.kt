package com.ariftuncer.workscheduletracker.view.operations

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ariftuncer.workscheduletracker.R
import com.ariftuncer.workscheduletracker.databinding.ActivityNewSalaryBinding
import com.google.android.material.button.MaterialButton

class NewSalaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewSalaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNewSalaryBinding.inflate(layoutInflater)
        val view : View = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.materialButtonToggleGroup2.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if(isChecked){
                val selectedButton = group.findViewById<MaterialButton>(checkedId)

                when(selectedButton){
                    binding.fullBtn -> Toast.makeText(this,"Full Btn", Toast.LENGTH_SHORT).show()
                }
            }

        }




    }

}