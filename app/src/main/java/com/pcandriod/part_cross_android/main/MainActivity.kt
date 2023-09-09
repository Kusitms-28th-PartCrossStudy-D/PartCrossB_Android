package com.pcandriod.part_cross_android.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pcandriod.part_cross_android.api.ArticleList
import com.pcandriod.part_cross_android.api.RetrofitClient
import com.pcandriod.part_cross_android.api.RetrofitService
import com.pcandriod.part_cross_android.databinding.ActivityMainBinding
import com.pcandriod.part_cross_android.detail.DetailActivity
import com.pcandriod.part_cross_android.write.WriteActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val itemList = ArrayList<PostItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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
        binding.rvPostList.layoutManager = LinearLayoutManager(this)

        postAdapter.setOnItemClickListener { position ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("item_index", position)
            Toast.makeText(this, "${position+1} 번째 글 클릭!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }
        val retrofit = RetrofitClient.getInstance().create(RetrofitService::class.java)

        // Retrofit에서 API 요청 결과를 처리하는 콜백 함수
        retrofit.getPostList().enqueue(object: Callback<ArticleList> {
            override fun onResponse(call: Call<ArticleList>, response: Response<ArticleList>) {
                if (response.isSuccessful) {
                    // API 요청이 성공하면 데이터를 가져옵니다.
                    val articleList = response.body()?.data?.toList()

                    articleList?.forEach { article ->
                        val postItem = PostItem(article.toString(), article.toString())
                        itemList.add(postItem)
                    }

                    // itemList를 사용하여 리사이클러뷰 어댑터를 업데이트합니다.
                    val postAdapter = PostAdapter(itemList)
                    binding.rvPostList.adapter = postAdapter
                    postAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ArticleList>, t: Throwable) {
                Log.e("레트로핏", "요청 실패: ${t.message}", t)
            }
        })
    }


    private fun initView() {

    }

}