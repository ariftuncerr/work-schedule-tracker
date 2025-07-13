package com.ariftuncer.workscheduletracker.view.operations.companyAndProjects

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ariftuncer.workscheduletracker.R
import com.ariftuncer.workscheduletracker.adapter.companyAdapter.CompanyAdapter
import com.ariftuncer.workscheduletracker.data.local.entity.CompanyEntity
import com.ariftuncer.workscheduletracker.data.local.entity.ProjectEntity
import com.ariftuncer.workscheduletracker.databinding.ActivityCompanyAndProjectsBinding
import com.google.android.material.button.MaterialButton
import java.util.UUID

class CompanyAndProjectsActivity : AppCompatActivity() {
    private val companyAndProjectsViewModel: CompanyAndProjectsViewModel by viewModels()
    private lateinit var binding: ActivityCompanyAndProjectsBinding
    private lateinit var amountType : String
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
        val companyAdapter = CompanyAdapter(this,null)

        val companyList = mutableListOf<CompanyEntity>()

        /*companyAndProjectsViewModel.projects.observe(this) { projectList ->
        }*/
        companyAndProjectsViewModel.companies.observe(this) {
            companyAdapter.updateList(companyList)

        }

        binding.companyRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.companyRecyclerView.adapter = companyAdapter

        binding.monthlyBtn.isEnabled = false


        binding.materialButtonToggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            if (isChecked) {
                val selectedButton = group.findViewById<MaterialButton>(checkedId)
                amountType = selectedButton.text.toString()
            }
        }

    }
    fun onSaveClick(view : View){
        val compName = binding.companyNameEditTxt.text.toString()
        val projectName = binding.projectNameEditTxt.text.toString()
        var salary = binding.salaryEditTxt.text.toString().toDouble()
        val userId = getSharedPreferences("user_session",MODE_PRIVATE).getString("userId","-1").toString()

        val company = CompanyEntity(UUID.randomUUID().toString(),userId,compName,null)
        val project = ProjectEntity(UUID.randomUUID().toString(),userId,company.id,projectName,salary)

        companyAndProjectsViewModel.insertCompany(company)
        companyAndProjectsViewModel.insertProject(project)

       // companyAndProjectsViewModel.getUserCompany(userId)

    }
}