package com.example.gitreposapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.gitreposapp.databinding.RepoListItemBinding
import com.example.gitreposapp.model.GitRepository

class RepositoriesAdapter(val context: Context) : PagingDataAdapter<GitRepository,RepositoryViewHolder>(RepoDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            RepoListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), context
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
    class RepositoryViewHolder(val binding: RepoListItemBinding, val context: Context) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: GitRepository?) {
           binding.repositoryNameTextView.text = item?.name
            binding.repositoryDescriptionTextView.text = item?.description
            binding.repositoryOwnerTextView.text = item?.owner?.userName

            binding.cardItemLayout.setOnClickListener{
                if(item != null){
                    val intent = Intent(context, RepoDetailsActivity::class.java)
                    val bundle = Bundle()
                    bundle.putParcelable(HomeActivity.REPO_ITEM, item)
                    intent.putExtra(HomeActivity.REPO_BUNDLE, bundle)
                    context.startActivity(intent)
                }
            }
        }
    }
