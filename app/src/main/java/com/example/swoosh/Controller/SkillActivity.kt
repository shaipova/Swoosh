package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.Model.Player
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)!!
    }

    fun onSkillFinishClick(view: View) {
        if (player.skill != "") {
            val finishIntent = Intent(this, FinishActivity::class.java)
            finishIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(finishIntent)
        } else {
            Toast.makeText(this, "please select a skill level", Toast.LENGTH_SHORT).show()
        }

    }

    fun onBeginnerClick(view: View) {
        ballerSkillBtn.isChecked = false
        player.skill = "begginer"
    }

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"
    }
}