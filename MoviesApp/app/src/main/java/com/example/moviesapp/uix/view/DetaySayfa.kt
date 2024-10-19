package com.example.moviesapp.uix.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun DetaySayfa(){
    Column (modifier = Modifier.fillMaxSize() , verticalArrangement = Arrangement.Center){
        ElevatedCard(modifier = Modifier.fillMaxWidth() , elevation =CardDefaults.cardElevation(24.dp) ) {
            Text("Selammmm")
        }
    }

}