package com.testy.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.testy.myapplication.ui.main.MainFragment
import com.testy.users.UserFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {

    val viewmodel by viewModels<MainViewModel>()

    override fun onStart() {
        super.onStart()
        Log.d("TTT", "onCreate")

    }

    override fun onResume() {
        super.onResume()
        Log.d("TTT", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TTT", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TTT", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TTT", "onDestroy")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TTT", "onCreate")
        setContentView(R.layout.main_activity)
        lifecycleScope.launchWhenResumed {
            Log.d("TTT", "run WhenResumed")
        }

        lifecycleScope.launchWhenStarted {
            Log.d("TTT", "run WhenStarted")
            viewmodel.tickFlow.collect {
                Log.d("TTT", "tickFlow collect $it")
            }
        }
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                Log.d("TTT", "onSTARTED rep rep")
            }
        }
//
//        lifecycleScope.addRepeatingJob(Lifecycle.State.STARTED) {
//
//        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commitNow()
        }
    }
}