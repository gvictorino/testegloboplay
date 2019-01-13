package com.globoplay.gvictorino.testegloboplay.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import com.globoplay.gvictorino.testegloboplay.Navigator
import com.globoplay.gvictorino.testegloboplay.R
import com.globoplay.gvictorino.testegloboplay.builders.MainPresenterBuilder

class MainActivity : AppCompatActivity(), MainView{
    private lateinit var presenter: MainPresenter
    private lateinit var progressBar : ProgressBar
    private lateinit var toolbar : Toolbar
    private lateinit var listOfPrograms : RecyclerView
    private lateinit var programAdapter: ProgramAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_main)

        presenter = MainPresenterBuilder.create(this,this, Navigator(this))
        progressBar = findViewById(R.id.progressBar)
        toolbar = findViewById(R.id.toolbar)
        programAdapter = ProgramAdapter(this,presenter)

        toolbar.title = this.resources.getString(R.string.app_name)

        listOfPrograms = findViewById(R.id.listOfPrograms)
        listOfPrograms.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        listOfPrograms.setHasFixedSize(true)
        listOfPrograms.adapter = programAdapter

        presenter.onCreateView()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onViewPaused()
    }

    override fun addProgramsList(programViewModel: MutableList<ProgramViewModel>){
        progressBar.visibility = View.GONE
        programAdapter.update(programViewModel)
    }

    override fun showError() {
        progressBar.visibility = View.GONE
    }

    override fun showLoad() {
        progressBar.visibility = View.VISIBLE
    }

    override fun removeLoad() {
        progressBar.visibility = View.GONE
    }
}