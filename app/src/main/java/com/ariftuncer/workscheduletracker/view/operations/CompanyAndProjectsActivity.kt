package com.ariftuncer.workscheduletracker.view.operations

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ariftuncer.workscheduletracker.R
import com.ariftuncer.workscheduletracker.adapter.companyAdapter.CompanyAdapter
import com.ariftuncer.workscheduletracker.adapter.projectAdapter.ProjectAdapter
import com.ariftuncer.workscheduletracker.databinding.ActivityCompanyAndProjectsBinding
import com.ariftuncer.workscheduletracker.databinding.ActivityMainBinding

class CompanyAndProjectsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCompanyAndProjectsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCompanyAndProjectsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val companyList = listOf<String>("Microsoft","Apple")
        val companyAdapter = CompanyAdapter(this,companyList)

        binding.companyRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.companyRecyclerView.adapter = companyAdapter

        binding.monthlyBtn.isEnabled = false





    }
    fun amountOperations(view : View){
        val activeBtn = when(binding.monthlyBtn.isEnabled){
            true -> binding.monthlyBtn
            else -> binding.dailyBtn
        }
        if(activeBtn == binding.monthlyBtn){
            binding.monthlyBtn.isEnabled = false
            binding.dailyBtn.isEnabled = true
        } else{
            binding.monthlyBtn.isEnabled = true
            binding.dailyBtn.isEnabled = false
        }

    }
}