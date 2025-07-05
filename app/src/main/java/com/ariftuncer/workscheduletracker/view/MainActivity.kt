package com.ariftuncer.workscheduletracker.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ariftuncer.workscheduletracker.R
import com.ariftuncer.workscheduletracker.adapter.operationAdapter.OperationAdapter
import com.ariftuncer.workscheduletracker.adapter.operationAdapter.OperationCard
import com.ariftuncer.workscheduletracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view : View = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val workRecordCard = OperationCard("workCalendar","Çalışma Kaydı", R.drawable.calendar_60)
        val newSalaryCard = OperationCard("newSalary","Yeni Maaş Girişi", R.drawable.new_salary_60)
        val analysisCard = OperationCard("details","Detaylı Analiz", R.drawable.analytics_60)
        val projectCompanyCard = OperationCard("company/project","Şirket/Proje", R.drawable.project_company_60)
        val operationCardList = listOf<OperationCard>(newSalaryCard,workRecordCard,analysisCard,projectCompanyCard)
        val operationAdapter = OperationAdapter(this, operationCardList)

        binding.operationRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.operationRecyclerView.adapter = operationAdapter
    }
}