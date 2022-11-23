package com.example.e4mdsantamariafernando

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.children

class GameActivity : AppCompatActivity() {

    private val gameManager = GameManager()

    private lateinit var wordDisplay: TextView
    private lateinit var lettersUsed: TextView
    private lateinit var hangedMan: ImageView
    private lateinit var loseText: TextView
    private lateinit var winText: TextView
    private lateinit var btnNewGame: Button
    private lateinit var lettersAvailable: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        hangedMan = findViewById(R.id.hangedMan)
        wordDisplay = findViewById(R.id.wordDisplay)
        lettersUsed = findViewById(R.id.lettersUsed)
        loseText = findViewById(R.id.loseText)
        winText = findViewById(R.id.winText)
        btnNewGame = findViewById(R.id.btnNewGame)
        lettersAvailable = findViewById(R.id.lettersAvailable)
        btnNewGame.setOnClickListener {
            startNewGame()
        }
        val gameState = gameManager.startNewGame()
        updateUI(gameState)

        lettersAvailable.children.forEach { letterView ->
            if (letterView is TextView) {
                letterView.setOnClickListener {
                    val gameState = gameManager.play((letterView).text[0])
                    updateUI(gameState)
                    letterView.visibility = View.GONE
                }
            }
        }
    }

    private fun updateUI(gameState: GameState) {
        when (gameState) {
            is GameState.Lost -> showGameLost(gameState.wordToGuess)
            is GameState.Running -> {
                wordDisplay.text = gameState.underscoreWord
                lettersUsed.text = "Letters used: ${gameState.lettersUsed}"
                hangedMan.setImageDrawable(ContextCompat.getDrawable(this, gameState.drawable))
            }
            is GameState.Won -> showGameWon(gameState.wordToGuess)
        }
    }

    private fun showGameLost(wordToGuess: String) {
        wordDisplay.text = wordToGuess
        loseText.visibility = View.VISIBLE
        hangedMan.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ahorcado_6))
        lettersAvailable.visibility = View.GONE
    }

    private fun showGameWon(wordToGuess: String) {
        wordDisplay.text = wordToGuess
        winText.visibility = View.VISIBLE
        lettersAvailable.visibility = View.GONE
    }

    private fun startNewGame() {
        loseText.visibility = View.GONE
        winText.visibility = View.GONE
        val gameState = gameManager.startNewGame()
        lettersAvailable.visibility = View.VISIBLE
        lettersAvailable.children.forEach { letterView ->
            letterView.visibility = View.VISIBLE
        }
        updateUI(gameState)
    }
}