package com.example.bankuishchallenge.repodetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.bankuishchallenge.databinding.RepoDetailFragmentBinding


class RepoDetailFragment : Fragment() {

    private var _binding: RepoDetailFragmentBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<RepoDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RepoDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillUi()
    }

    private fun fillUi() {
        with(binding) {
           Glide.with(requireContext())
                .load(args.repoInfo.owner.avatar_url)
                .into(this.ivDetailRepoOwner)
            tvRepoVisibility.text = args.repoInfo.visibility
            tvRepoDescription.text = args.repoInfo.description
        }

        }
    }
