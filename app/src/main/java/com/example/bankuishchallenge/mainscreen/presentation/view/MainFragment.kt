package com.example.bankuishchallenge.mainscreen.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bankuishchallenge.databinding.MainFragmentBinding
import com.example.bankuishchallenge.mainscreen.presentation.model.UiState
import com.example.bankuishchallenge.mainscreen.presentation.viewmodel.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    val mainFragmentViewModel: MainFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainFragmentViewModel.initGetRepos()
        mainFragmentViewModel.reposResult.observe(requireActivity()) {
            when (it) {
                is UiState.UIShowLoading -> {

                }
                is UiState.RepositoriesList -> {

                }
            }
        }
    }
}

