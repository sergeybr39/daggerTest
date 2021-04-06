package com.testy.boards

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.testy.boards.di.BoardComponent
import com.testy.boards.ui.main.BoardFragment
import com.testy.di_core.ComponentInterface
import com.testy.di_core.DepTest
import com.testy.di_core.provideComponent
import javax.inject.Inject

class BoardActivity : AppCompatActivity(),ProvideComponentFromActivity<BoardComponent> {

    lateinit var component:BoardComponent

    override fun provide(): BoardComponent {
        return component
    }

    @Inject
    lateinit var depTest: DepTest

    override fun onCreate(savedInstanceState: Bundle?) {
        component = provideComponent<BoardComponent.Factory>().create(this)
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.board_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BoardFragment.newInstance())
                .commitNow()
        }

        Log.d("TTT","Hello: ${depTest.show()}")
    }
}

interface ProvideComponentFromActivity<T:ComponentInterface>{
    fun provide():T
}

fun <T:ComponentInterface> Fragment.provideComponentTest():T{
    return (requireActivity() as ProvideComponentFromActivity<T>).provide()
}