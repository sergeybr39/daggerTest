package com.testy.users

import android.content.ContentProvider
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.testy.di_core.ComponentProvider
import com.testy.di_core.DepTest
import com.testy.di_core.DepsModule
import com.testy.users.di.UserComponent
import com.testy.users.di.UserDeps
import javax.inject.Inject

class UserFragment : Fragment() {


    @Inject
    lateinit var depsTest: DepTest

    @Inject
    lateinit var pojoProvider: IPojoProvider

    override fun onAttach(context: Context) {
        (requireActivity().applicationContext as ComponentProvider).provide(UserComponent::class.java).inject(this)

        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tv = view.findViewById<TextView>(R.id.tv_test)
        tv.text = "${depsTest.show()} ${pojoProvider.providePojo().name}"

    }
}