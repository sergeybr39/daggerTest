package com.testy.users

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.testy.di_core.DepTest
import com.testy.di_core.provideComponent
import com.testy.di_core.Blob
import com.testy.users.di.UserComponent
import javax.inject.Inject

class UserFragment : Fragment() {


    @Inject
    lateinit var depsTest: DepTest

    @Inject
    lateinit var pojoProvider: IPojoProvider

    @Inject
    lateinit var blob: Blob

    override fun onAttach(context: Context) {
        provideComponent<UserComponent.Factory>().create(UserFragment.instance(55))
            .inject(this)

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
        tv.text = "${depsTest.show()} ${pojoProvider.providePojo().name} ---${pojoProvider.providePojo().age}----::: ${blob.i}"

    }

    companion object {
        const val EXTRA_KEY_TEAM_ID = "team_id"
        fun instance(teamId: Int): UserFragment {
            return UserFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_KEY_TEAM_ID, teamId)
                }
            }
        }
    }
}