package com.globoplay.gvictorino.testegloboplay.ui.details

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.globoplay.gvictorino.testegloboplay.ImageLoader
import com.globoplay.gvictorino.testegloboplay.R
import com.globoplay.gvictorino.testegloboplay.builders.ProgramDetailsPresenterBuilder

class ProgramDetailsActivity : AppCompatActivity(), ProgramDetailsView{
    private lateinit var presenter: ProgramDetailsPresenter
    private lateinit var toolbar : Toolbar
    private lateinit var description : TextView
    private lateinit var programId : TextView
    private lateinit var serviceId : TextView
    private lateinit var videoId : TextView
    private lateinit var typeProgram : TextView
    private lateinit var kind : TextView
    private lateinit var fullEpisode :TextView
    private lateinit var favorites : TextView
    private lateinit var duration: TextView
    private lateinit var thumb : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        description = findViewById(R.id.description)
        programId = findViewById(R.id.programID)
        serviceId = findViewById(R.id.serviceID)
        videoId = findViewById(R.id.videoID)
        typeProgram = findViewById(R.id.programType)
        kind = findViewById(R.id.kind)
        fullEpisode = findViewById(R.id.fullEpisode)
        favorites = findViewById(R.id.favorites)
        duration = findViewById(R.id.duration)
        thumb = findViewById(R.id.thumb)
        presenter = ProgramDetailsPresenterBuilder.create(this)

        if(supportActionBar != null) run {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            toolbar.setNavigationOnClickListener { finish() }
        }

        presenter.onCreateView()
    }

    override fun addProgramDetails() {
        val extras = intent.extras
        val programID = extras.getInt(PROGRAM_ID, 0)
        val programName = extras.getString(PROGRAM_NAME)
        val programThumb = extras.getString(PROGRAM_THUMB)
        val programServiceID = extras.getInt(PROGRAM_SERVICEID)
        val programVideoID = extras.getInt(PROGRAM_VIDEOID)
        val programType = extras.getString(PROGRAM_TYPE)
        val programKind = extras.getString(PROGRAM_KIND)
        val programFullEpisode = extras.getBoolean(PROGRAM_FULL_EPISODE)
        val programFavorites = extras.getInt(PROGRAM_FAVORITES)
        val programDuration = extras.getString(PROGRAM_DURATION)
        val programDescription = extras.getString(PROGRAM_DESCRIPTION)

        toolbar.title = programName
        ImageLoader.loadFitCenter(this,programThumb, R.drawable.mosaic_pattern,thumb)
        description.text = programDescription
        programId.text = programID.toString()
        serviceId.text = programServiceID.toString()
        videoId.text = programVideoID.toString()
        typeProgram.text = programType
        kind.text = programKind

        if(programFullEpisode){
            fullEpisode.text = "Episódio completo"
        } else "Este programa não é um episódio completo"

        favorites.text = programFavorites.toString()
        duration.text = "$programDuration mins"

    }

    override fun showLoad() {
    }

    override fun removeLoad() {
    }

    override fun showError() {
    }


    companion object {
        val PROGRAM_ID = "ProgramID"
        val PROGRAM_NAME = "ProgramName"
        val PROGRAM_THUMB = "ProgramThumb"
        val PROGRAM_SERVICEID = "ProgramServiceID"
        val PROGRAM_VIDEOID = "ProgramVideoID"
        val PROGRAM_TYPE = "ProgramType"
        val PROGRAM_KIND = "ProgramKind"
        val PROGRAM_FULL_EPISODE = "ProgramFullEpisode"
        val PROGRAM_FAVORITES = "ProgramFavorites"
        val PROGRAM_DURATION = "ProgramDuration"
        val PROGRAM_DESCRIPTION = "ProgramDescription"
    }
}
