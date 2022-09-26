package com.example.bankuishchallenge.repodetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bankuishchallenge.databinding.RepoDetailFragmentBinding


class RepoDetailFragment : Fragment() {

    private var _binding: RepoDetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RepoDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}