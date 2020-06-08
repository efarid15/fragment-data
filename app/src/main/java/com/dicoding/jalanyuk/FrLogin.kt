package com.dicoding.jalanyuk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_login.view.*


class FrLogin: Fragment() {
    lateinit var commFragmentData: Communicator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fr_login, container, false)
        commFragmentData = activity as Communicator

        rootView.btnLogin.setOnClickListener {
            commFragmentData.passDataCom(rootView.edtUserName.text.toString())
        }
        return rootView
    }

}