package avila.domingo.lifecycle.modules

import android.util.Log
import avila.domingo.lifecycle.lifecycle.ILifecycleObserver

class Module1LifecycleSubscriber : ILifecycleObserver {

    private val TAG = "popo"

    fun doStuff() {
        Log.d(TAG, "Hi, look at me ${this.javaClass.name}, I'm doing stuff now")
    }

    override fun resume() {
        Log.d(TAG, "1 resume")
    }

    override fun pause() {
        Log.d(TAG, "1 pause")
    }
}