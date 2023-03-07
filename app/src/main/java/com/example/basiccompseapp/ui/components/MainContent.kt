package com.example.basiccompseapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.basiccompseapp.network.model.Hit

@Preview
@Composable
fun MainContent(viewModel: MainViewModel = hiltViewModel()) {

    val query: MutableState<String> = remember { mutableStateOf("") }
    
    Surface(modifier = Modifier.fillMaxHeight()) {
        Column(modifier = Modifier.padding(8.dp)) {

            OutlinedTextField(value = query.value, onValueChange ={
                query.value=it
                viewModel.getImageList(query.value) },
                enabled = true,
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },)

//            What to do when loading
            if (viewModel.list.value.isLoading){
                Box(modifier= Modifier.fillMaxSize()){
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            if (viewModel.list.value.error.isNotBlank()){
                Box(modifier= Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = viewModel.list.value.error
                    )
                }
            }
//
            if (viewModel.list.value.data.isNotEmpty()){

                LazyVerticalGrid(columns = GridCells.Fixed(2)){
                    viewModel.list.value.data?.let{
                        items(it){
                            MainContentItem(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainContentItem(hit: Hit) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            painter = rememberImagePainter(data = hit.largeImageURL),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
    }


}