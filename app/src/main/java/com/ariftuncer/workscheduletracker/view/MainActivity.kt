package com.ariftuncer.workscheduletracker.view

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ariftuncer.workscheduletracker.R
import com.ariftuncer.workscheduletracker.adapter.operationAdapter.OperationAdapter
import com.ariftuncer.workscheduletracker.adapter.operationAdapter.OperationCard
import com.ariftuncer.workscheduletracker.data.local.entity.UserEntity
import com.ariftuncer.workscheduletracker.databinding.ActivityMainBinding
import java.util.UUID

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userPref : SharedPreferences
    private val mainViewModel : MainViewModel by viewModels()
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
        tryAddUser()


        val workRecordCard = OperationCard("workCalendar","Çalışma Kaydı", R.drawable.calendar_60)
        val newSalaryCard = OperationCard("newSalary","Yeni Maaş Girişi", R.drawable.new_salary_60)
        val analysisCard = OperationCard("details","Detaylı Analiz", R.drawable.analytics_60)
        val projectCompanyCard = OperationCard("company/project","Şirket/Proje", R.drawable.project_company_60)
        val operationCardList = listOf<OperationCard>(newSalaryCard,workRecordCard,analysisCard,projectCompanyCard)
        val operationAdapter = OperationAdapter(this, operationCardList)

        binding.operationRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.operationRecyclerView.adapter = operationAdapter
    }
    fun tryAddUser() {
        val user1 = UserEntity(
            UUID.randomUUID().toString(),
            "Arif Tunçer",
            "arif.61.tuncer@gmail.com",
            "6161",
            System.currentTimeMillis()
        )
        mainViewModel.insert(user1)
        userPref = applicationContext.getSharedPreferences("user_session",MODE_PRIVATE)
        userPref.edit().putString("userId",user1.id).apply()

    }



}