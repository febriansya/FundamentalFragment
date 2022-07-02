package com.example.fundamentalfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class HomeFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    //    Oncreate in Activity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnButton = view.findViewById<Button>(R.id.btn_category)
        btnButton.setOnClickListener(this)
    }


    //    replace fragment in activity
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_category -> {
                val anonymousFragment = AnonymousFragment()
                val mFragmentManager = parentFragmentManager
                mFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.frame_container,
                        anonymousFragment,
                        AnonymousFragment::class.java.simpleName
                    )
                    addToBackStack(null)
                    commit()
                }
                Toast.makeText(context, "that great", Toast.LENGTH_SHORT).show()
            }
        }
    }
}