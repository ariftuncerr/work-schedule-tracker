package com.ariftuncer.workscheduletracker

import android.content.Context
import android.graphics.Path
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ariftuncer.workscheduletracker.adapter.OperationAdapter
import com.ariftuncer.workscheduletracker.adapter.OperationCard
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
        val workRecordCard = OperationCard("Çalışma Kaydı",R.drawable.calendar_60)
        val newSalaryCard = OperationCard("Yeni Maaş Girişi",R.drawable.new_salary_60)
        val analysisCard = OperationCard("Detaylı Analiz",R.drawable.analytics_60)
        val projectCompanyCard = OperationCard("Şirket / Proje",R.drawable.project_company_60)
        val operationCardList = listOf<OperationCard>(newSalaryCard,workRecordCard,analysisCard,projectCompanyCard)
        val operationAdapter = OperationAdapter(applicationContext,operationCardList)

        binding.operationRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.operationRecyclerView.adapter = operationAdapter
    }
}