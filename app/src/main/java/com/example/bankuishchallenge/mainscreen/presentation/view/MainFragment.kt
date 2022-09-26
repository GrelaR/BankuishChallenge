package com.example.bankuishchallenge.mainscreen.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bankuishchallenge.databinding.MainFragmentBinding
import com.example.bankuishchallenge.mainscreen.presentation.model.ReposListResponse
import com.example.bankuishchallenge.mainscreen.presentation.model.RepositoriesItemModel
import com.example.bankuishchallenge.mainscreen.presentation.adapter.RecyclerAdapter
import com.example.bankuishchallenge.mainscreen.presentation.model.UiState
import com.example.bankuishchallenge.mainscreen.presentation.viewmodel.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(), RecyclerAdapter.OnRepoClickListener {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private val mainFragmentViewModel: MainFragmentViewModel by viewModels()

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

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        mainFragmentViewModel.initGetRepos()
        mainFragmentViewModel.reposResult.observe(requireActivity()) {
            when (it) {
                is UiState.UIShowLoading -> {
                    showLoading(it.isShow)
                }
                is UiState.RepositoriesList -> {
                    showLoading(false)
                    setAdapter(it.listOfRepos)
                }
            }
        }

    }

    private fun showLoading(isShow: Boolean) {
        binding.loading.isVisible = isShow
    }

    private fun setAdapter(data: ReposListResponse) {
        binding.recyclerView.adapter = RecyclerAdapter(requireContext(), data.items, this)
    }

    override fun onRepoClick(item: RepositoriesItemModel) {
        val directions = MainFragmentDirections.actionMainFragmentToRepoDetailFragment(item)
        findNavController().navigate(directions)
    }


}

