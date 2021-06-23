package com.example.notesmvvm.screen.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.notesmvvm.R
import com.example.notesmvvm.databinding.FragmentStartBinding
import com.example.notesmvvm.utilits.TYPE_ROOM


class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: StartFragmentViewModel
    private lateinit var btn_room: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.fragment_start,container,false)
        btn_room = view.findViewById(R.id.btn_room)

        _binding = FragmentStartBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()

    }
    private fun initialization(){
        viewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)
        btn_room.setOnClickListener{
            viewModel.initDatabase(TYPE_ROOM)
        }
    }
}