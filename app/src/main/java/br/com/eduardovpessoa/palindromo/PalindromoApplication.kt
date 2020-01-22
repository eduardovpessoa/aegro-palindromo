package br.com.eduardovpessoa.palindromo

import android.app.Application
import android.content.Context

class PalindromoApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: PalindromoApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
    }
}