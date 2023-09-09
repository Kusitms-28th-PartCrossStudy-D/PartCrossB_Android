package com.pcandriod.part_cross_android.detail

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.pcandriod.part_cross_android.databinding.ActivityDetailBinding
import com.pcandriod.part_cross_android.main.MainActivity
import com.pcandriod.part_cross_android.write.WriteActivity

class DetailActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
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

    }
}