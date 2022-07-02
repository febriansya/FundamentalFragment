package com.example.fundamentalfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment


class ShowDialogFragment : DialogFragment() {

    private lateinit var btnChoose: Button
    private lateinit var btnClose: Button
    private lateinit var rgOption: RadioGroup
    private lateinit var rbYan: RadioButton
    private lateinit var rbDarmansyah: RadioButton
    private lateinit var rbSubaedah: RadioButton
    private lateinit var rbFatia: RadioButton

    private var optionDialogListener: OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnChoose = view.findViewById(R.id.btn_pilih)
        btnClose = view.findViewById(R.id.id_close)
        rgOption = view.findViewById(R.id.rd_group_show_dialog)
        rbYan = view.findViewById(R.id.rb_yan)
        rbDarmansyah = view.findViewById(R.id.rb_darmansyah)
        rbSubaedah = view.findViewById(R.id.rb_subaedah)
        rbFatia = view.findViewById(R.id.rb_fatia)


        btnChoose.setOnClickListener {
            val checkRadioButton = rgOption.checkedRadioButtonId
            if (checkRadioButton != -1) {
//                variable for save return value from RadioButton
                var coach: String? = when (checkRadioButton) {
                    R.id.rb_fatia -> rbFatia.text.toString().trim()
                    R.id.rb_subaedah -> rbSubaedah.text.toString().trim()
                    R.id.rb_darmansyah -> rbDarmansyah.text.toString().trim()
                    R.id.rb_yan -> rbYan.text.toString().trim()
                    else -> null
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }
        btnClose.setOnClickListener {
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment

        if (fragment is DetailFragment){
            this.optionDialogListener = fragment.optionDialogListener
        }
    }
    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }
    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }
}

