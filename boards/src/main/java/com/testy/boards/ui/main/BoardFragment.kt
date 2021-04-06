package com.testy.boards.ui.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.testy.boards.R
import com.testy.boards.di.BoardComponent
import com.testy.boards.provideComponentTest
import com.testy.di_core.DepTest
import com.testy.di_core.provideComponent
import javax.inject.Inject

class BoardFragment : Fragment() {

    companion object {
        fun newInstance() = BoardFragment()
    }

    @Inject
    lateinit var depTest: DepTest

    override fun onAttach(context: Context) {
        provideComponentTest<BoardComponent>().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.board_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.message).text = "Boom! ${depTest.show()}"

        view.findViewById<Button>(R.id.button).setOnClickListener {

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, DocFragment.instance(22), "findThisFragment")
                .addToBackStack(null)
                .commit()
        }
    }
}