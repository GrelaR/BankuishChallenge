package com.example.bankuishchallenge.mainscreen.presentation.adapter

import android.content.Context
import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bankuishchallenge.core.BaseViewHolder
import com.example.bankuishchallenge.databinding.RepositorieItemBinding
import com.example.bankuishchallenge.mainscreen.presentation.model.RepositoriesItemModel

class RecyclerAdapter(
    private val context: Context,
    private val listRepos: List<RepositoriesItemModel>,
    private val itemClickListener: OnRepoClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return ReposViewHolder(RepositorieItemBinding.inflate(from(parent.context)))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is ReposViewHolder -> holder.bind(listRepos[position], position)
        }
    }

    override fun getItemCount(): Int = listRepos.size

    inner class ReposViewHolder(private val binding: RepositorieItemBinding) :
        BaseViewHolder<RepositoriesItemModel>(binding.root) {
        override fun bind(item: RepositoriesItemModel, position: Int) {
            with(binding) {
                cardView.setOnClickListener {
                    itemClickListener.onRepoClick(item)
                }
                tvAuthorName.text = item.name
                tvRepoName.text = item.full_name
                Glide.with(context)
                    .load(item.owner.avatar_url)
                    .into(ivRepoOwner)
            }
        }
    }

    interface OnRepoClickListener {
        fun onRepoClick(item: RepositoriesItemModel)
    }
}