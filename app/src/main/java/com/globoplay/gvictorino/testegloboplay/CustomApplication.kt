package com.globoplay.gvictorino.testegloboplay

import android.support.multidex.MultiDexApplication

class CustomApplication : MultiDexApplication(){

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: CustomApplication
    }
}