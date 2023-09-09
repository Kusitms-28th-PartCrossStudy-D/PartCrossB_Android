package com.pcandriod.part_cross_android.detail

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pcandriod.part_cross_android.api.ArticleList
import com.pcandriod.part_cross_android.api.RetrofitClient
import com.pcandriod.part_cross_android.api.RetrofitService
import com.pcandriod.part_cross_android.databinding.ActivityDetailBinding
import com.pcandriod.part_cross_android.main.MainActivity
import com.pcandriod.part_cross_android.write.WriteActivity
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    lateinit var contentService: RetrofitService



    val retrofit = Retrofit.Builder().baseUrl("https://kusitms.shop")
        .addConverterFactory(GsonConverterFactory.create()).build()
    val service = retrofit.create(RetrofitService::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val titleEdit = binding.titleEdit
        val contentEdit =  binding.contentEdit
        val fixbtn = binding.fixbtn
        val deletebtn = binding.deletebtn

        val intent = Intent(this, MainActivity::class.java)
        val intent1 = Intent(this, WriteActivity::class.java)

        //수정하기 버튼 이벤트
        fixbtn.setOnClickListener{
            startActivity(intent1)
        }
        //삭제하기
        deletebtn.setOnClickListener{
            startActivity(intent)
        }

        service.getDetailContent(0)?.enqueue(object : retrofit2.Callback<ArticleList.ArticleResponse>{
            override fun onResponse(
                call: Call<ArticleList.ArticleResponse>,
                response: Response<ArticleList.ArticleResponse>
            ) {
                if(response.isSuccessful)
                {
                    var result:ArticleList.ArticleResponse? = response.body()
                    Log.d("success", "onresponse 성공"+ result?.toString())
                }else{
                    Log.d("fail", "onresponse 실패")
                }
            }

            override fun onFailure(call: Call<ArticleList.ArticleResponse>, t: Throwable) {
                Log.d("Fail", "onfailur에러"+t.message.toString())
            }
        })

    }

}