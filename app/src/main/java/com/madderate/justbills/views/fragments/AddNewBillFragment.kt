package com.madderate.justbills.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.madderate.justbills.R
import com.madderate.justbills.databinding.FragmentAddNewBillBinding

class AddNewBillFragment : Fragment() {

    private lateinit var binding: FragmentAddNewBillBinding

    private val items = listOf("Option 1", "Option 2", "Option 3")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNewBillBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter =
            ArrayAdapter(requireContext(), R.layout.view_add_new_bill_fragment_menu, items)
    }

    companion object {
        @JvmStatic
        fun newInstance() = AddNewBillFragment()
    }
}