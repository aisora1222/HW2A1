package com.example.hw2a1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hw2a1.ui.theme.HW2A1Theme
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    private var quotesInd = mutableStateOf(0)

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate (savedInstanceState)
        setContent{
            quoteGenerator(quotesInd)
        }
    }

}
@Composable

fun quoteGenerator(quoteInd:MutableState<Int>){
    val quotes = mutableListOf(


        mutableListOf("Many of life’s failures are people who did not realize how close they were to success when they gave up.", " Thomas A. Edison"),
        mutableListOf("Never let the fear of striking out keep you from playing the game.", " Babe Ruth"),
        mutableListOf("Don’t settle for what life gives you; make life better and build something.", " Ashton Kutcher"),
        mutableListOf("The best way to predict your future is to create it.", " Abraham Lincoln"),
        mutableListOf("I believe every human has a finite number of heartbeats. I don't intend to waste any of mine.", " Neil Armstrong"),
        mutableListOf("If you want to live a happy life, tie it to a goal, not to people or things", " Albert Einstein"),
        mutableListOf("It had long since come to my attention that people of accomplishment rarely sat back and let things happen to them. They went out and happened to things.", " Leonardo Da Vinci"),
        mutableListOf("I can accept failure, everyone fails at something. But I can’t accept not trying", " Michael Jordan")


        )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(

            text = "'" +quotes[quoteInd.value].first() + "'",
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "\n" + quotes[quoteInd.value][1],
            fontSize = 24.sp,
            textAlign = TextAlign.End,
            color = Color.Black,
            fontWeight = FontWeight.Bold


        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            quoteInd.value = (quotes.indices).random()
        }){
            Text(text="New Quote")
        }
    }
}

