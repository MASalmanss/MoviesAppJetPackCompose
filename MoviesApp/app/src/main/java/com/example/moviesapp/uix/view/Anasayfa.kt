package com.example.moviesapp.uix.view

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moviesapp.data.entity.Filmler
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(navController: NavController) {
    val filmlerListesi = remember { mutableStateListOf<Filmler>() }
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        val f1 = Filmler(1, "Django", "django", 24)
        val f2 = Filmler(2, "Interstellar", "interstellar", 32)
        val f3 = Filmler(3, "Inception", "inception", 16)
        val f4 = Filmler(4, "The Hateful Eight", "thehatefuleight", 28)
        val f5 = Filmler(5, "The Pianist", "thepianist", 18)
        val f6 = Filmler(6, "Anadoluda", "anadoluda", 10)
        filmlerListesi.addAll(listOf(f1, f2, f3, f4, f5, f6))
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Filmler") })
        },
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) } // SnackbarHost ekliyoruz
    ) { paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()  // Grid tüm ekranı kapsar
                .padding(paddingValues),  // Scaffold padding'i
            columns = GridCells.Fixed(count = 2)  // İki sütunlu grid
        ) {
            items(filmlerListesi) { film ->
                Card(modifier = Modifier.padding(all = 5.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)  // Kart içindeki düzen
                    ) {
                        Image(
                            painter = painterResource(
                                id = LocalContext.current.resources.getIdentifier(
                                    film.resim, "drawable", LocalContext.current.packageName
                                )
                            ),
                            contentDescription = null,
                            modifier = Modifier.size(200.dp, 300.dp)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("${film.fiyat} TL", fontSize = 20.sp)
                            Button(onClick = {
                                scope.launch {
                                    snackBarHostState.showSnackbar("${film.ad} sepete eklendi")
                                }
                            }) {
                                Text("Sepet")
                            }
                        }
                    }
                }
            }
        }
    }
}
