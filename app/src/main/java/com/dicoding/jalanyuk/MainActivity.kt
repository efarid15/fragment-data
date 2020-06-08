package com.dicoding.jalanyuk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), Communicator {
    private val fragmentManager = supportFragmentManager
    private val fragmentLogin = FrLogin()
    private val fragmentWelcome = FrWelcome()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            addFirstFragment()
        }
    }

    fun swapUp(view: View) {
        changeFragment(fragmentLogin)
    }

    fun addFirstFragment() {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fr_utama, fragmentLogin)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.commit()
    }

    fun changeFragment(f: Fragment) {
        // ganti fragment sesuai dengan nama fragment
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fr_utama, f)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(f.toString())
        fragmentTransaction.commit()
    }

    override fun passDataCom(editNama: String) {
        val bundle = Bundle()
        bundle.putString("input_nama", editNama)

        fragmentWelcome.arguments = bundle
        changeFragment(fragmentWelcome)

    }
}

interface Communicator {
    fun passDataCom(editNama: String)
}

