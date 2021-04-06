package com.testy.boards.ui.main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.testy.boards.R
import com.testy.boards.di.BoardComponent
import com.testy.boards.provideComponentTest
import com.testy.di_core.Blob
import javax.inject.Inject

class DocFragment : Fragment() {

    @Inject
    lateinit var blob: Blob

    override fun onAttach(context: Context) {
        provideComponentTest<BoardComponent>().docComponent().create(this).inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.doc_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.message).text = "JJJ ${blob.i}"
    }

    companion object {
        const val EXTRA_KEY_TEAM_ID = "team_id"
        fun instance(teamId: Int): DocFragment {
            return DocFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_KEY_TEAM_ID, teamId)
                }
            }
        }
    }
}