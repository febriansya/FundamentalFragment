package com.example.fundamentalfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class AnonymousFragment : Fragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anonymous, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.btn_to_detail)
        button.setOnClickListener(this)
    }


    //    replace fragment in Activity
    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_to_detail) {
            
            val detailFragment = DetailFragment()

            val mBundle = Bundle()
            mBundle.putString(DetailFragment.EXTRA_NAME, "yan febriansyah")
            val description = "kategori ini akan berisi produk-produk lifestyle"

            detailFragment.arguments = mBundle
            detailFragment.description = description


            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frame_container,
                    detailFragment,
                    DetailFragment::class.java.simpleName
                )
                addToBackStack(null)
                commit()
            }
        }
    }

}