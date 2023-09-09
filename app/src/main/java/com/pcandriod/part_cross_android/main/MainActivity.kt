package com.pcandriod.part_cross_android.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pcandriod.part_cross_android.api.RetrofitService
import com.pcandriod.part_cross_android.databinding.ActivityMainBinding
import com.pcandriod.part_cross_android.detail.DetailActivity
import com.pcandriod.part_cross_android.write.WriteActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var articleService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initView()
    }


    private fun initView() {
        val itemPost = ArrayList<PostItem>()

        itemPost.add(PostItem("제목1", "내용1"))
        itemPost.add(PostItem("제목2", "내용2"))
        itemPost.add(PostItem("제목3", "내용3"))
        itemPost.add(PostItem("제목4", "내용4"))
        itemPost.add(PostItem("제목5", "내용5"))
        itemPost.add(PostItem("제목6", "내용6"))
        itemPost.add(PostItem("제목7", "내용7"))
        itemPost.add(PostItem("제목8", "내용8"))
        itemPost.add(PostItem("제목9", "내용9"))
        itemPost.add(PostItem("제목10", "내용10"))

        binding.ibtnEdit.setOnClickListener {
            val intent = Intent(this, WriteActivity::class.java)
            startActivity(intent)
        }

        val postAdapter = PostAdapter(itemPost)
        postAdapter.notifyDataSetChanged()

        binding.rvPostList.adapter = postAdapter

        postAdapter.setOnItemClickListener { position ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("item_index", position)
            Toast.makeText(this, "${position+1} 번째 글 클릭!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
    }

    private fun getArticleList() {
        lifecycleScope.launch {
            val response = articleService.getPostList()
            val statusCode = response

            withContext(Dispatchers.Main) {
            }
        }
    }
}