package com.globoplay.gvictorino.testegloboplay.ui.splash

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.globoplay.gvictorino.testegloboplay.Navigator
import com.globoplay.gvictorino.testegloboplay.R

class SplashActivity : Activity(){
    companion object {
        private val SPLASH_DURATION = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
    }

    public override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            Navigator(this).goToMainActivity()
        }, SPLASH_DURATION.toLong())
    }
}
