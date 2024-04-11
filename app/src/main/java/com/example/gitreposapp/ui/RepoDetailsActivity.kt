package com.example.gitreposapp.ui

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.gitreposapp.databinding.ActivityRepoDetailsBinding
import com.example.gitreposapp.model.GitRepository
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepoDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepoDetailsBinding
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepoDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun init() {
        val extras = intent.getBundleExtra(HomeActivity.REPO_BUNDLE)
         val repoData: GitRepository? = extras?.getParcelable(HomeActivity.REPO_ITEM, GitRepository::class.java)
        if (repoData != null) {
            setData(repoData)
        }
    }
    fun setData(repoData: GitRepository) {
        binding.repoUserImg.let {
            Glide.with(this)
                .load(repoData.owner?.url)
                .into(it)
        };
        binding.repoName.text = repoData.name.toString()
        binding.repoDescription.text = "Description:- ${repoData.description}"
        binding.repoProjectLink.text = Html.fromHtml(repoData.url.toString())
        binding.repoProjectLink.movementMethod = LinkMovementMethod.getInstance()
        binding.repoProgrammingLang.text =  "Programmning Language:- ${repoData.programmingLanguage}"
        binding.repoNumberOfStars.text =  "Stars:- ${repoData.numberOfStars}*"


    }
}