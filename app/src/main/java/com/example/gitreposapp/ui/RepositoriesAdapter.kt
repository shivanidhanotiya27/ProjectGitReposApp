package com.example.gitreposapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gitreposapp.databinding.RepoListItemBinding
import com.example.gitreposapp.model.GitRepository
import dagger.hilt.android.AndroidEntryPoint

class RepositoriesAdapter : PagingDataAdapter<GitRepository,RepositoryViewHolder>(RepoDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            RepoListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

    class RepoDiffCallBack : DiffUtil.ItemCallback<GitRepository>() {
        override fun areItemsTheSame(oldItem: GitRepository, newItem: GitRepository): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GitRepository, newItem: GitRepository): Boolean {
            return oldItem == newItem
        }
    }

    class RepositoryViewHolder(val binding: RepoListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: GitRepository?) {
           binding.repositoryNameTextView.text = item?.name
            binding.repositoryDescriptionTextView.text = item?.description
            binding.repositoryOwnerTextView.text = item?.owner?.userName
        }

    }
