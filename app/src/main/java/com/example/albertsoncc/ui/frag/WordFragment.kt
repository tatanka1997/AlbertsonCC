package com.example.albertsoncc.ui.frag

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.albertsoncc.R
import com.example.albertsoncc.data.Acronyms
import com.example.albertsoncc.databinding.FragmentWordBinding
import com.example.albertsoncc.ui.adapter.WordAdapter
import com.example.albertsoncc.util.UIstate
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "WordFragment"

@AndroidEntryPoint
class WordFragment : Fragment(R.layout.fragment_word) {
    private lateinit var binding: FragmentWordBinding
    private val viewModel by viewModels<WordViewModel>()
    private val adapter: WordAdapter by lazy { WordAdapter(emptyList()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentWordBinding.bind(view)

        viewModel.data.observe(viewLifecycleOwner){
            when (it){
                is UIstate.Loading -> {
                    Log.d("API Response: ", "LOADING")

                }
                is UIstate.Success<*> -> {
                    Log.d("API Response: ", "Success -> ${it.uiResponse as Acronyms}")
                    updateAdapter(it.uiResponse as Acronyms)
                }
                is UIstate.Fail -> {
                    Log.d("API Response: ", "Error -> ${it.error}")
                    binding.errorText.text = it.error.message ?: "Unknown error"

                }
            }
        }
        initViews()
        viewModel.getWord()
    }

    private fun updateAdapter(acronyms: Acronyms) {
        Log.d(TAG, "updateAdapter: $acronyms")
        adapter.updateList(acronyms[0].lfs)
    }

    private fun initViews() {
        binding.acronymList.adapter = adapter
        binding.acronymList.layoutManager = LinearLayoutManager(context)
    }

}