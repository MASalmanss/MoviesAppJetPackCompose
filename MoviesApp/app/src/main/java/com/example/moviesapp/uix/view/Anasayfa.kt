package com.example.moviesapp.uix.view

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesapp.data.entity.Filmler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(navController: NavController){
    val filmlerListesi = remember { mutableListOf<Filmler>() }
        LaunchedEffect(key1 = true){
        val f1 = Filmler(1,"Django","django",24)
        val f2 = Filmler(2,"Interstellar","interstellar",32)
        val f3 = Filmler(3,"Inception","inception",16)
        val f4 = Filmler(4,"The Hateful Eight","thehatefuleight",28)
        val f5 = Filmler(5,"The Pianist","thepianist",18)
        val f6 = Filmler(6,"Anadoluda","anadoluda",10)
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)
    }

    Scaffold (topBar = {
        TopAppBar(title = { Text("Filmler") })
    }){paddingValues ->
        LazyVerticalGrid(modifier = Modifier.fillMaxSize().padding(paddingValues) , columns = GridCells.Fixed(count = 2)) {
            items(count = filmlerListesi.count() , itemContent = {
                val film = filmlerListesi[it]
                Card(modifier = Modifier.padding(all = 5.dp)){
                    Column (modifier = Modifier.fillMaxWidth()){
                        val activity = (LocalContext.current as Activity)
                        Image(bitmap = ImageBitmap.imageResource(id = activity.resources.getIdentifier(film.resim , "drawable" , activity.packageName)) , contentDescription = "")

                    }
                }
            })
        }
    }

}