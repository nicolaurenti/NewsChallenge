package com.example.newschallenge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newschallenge.R
import com.example.newschallenge.viewmodel.NewsViewModel
import kotlinx.coroutines.launch

@Composable
fun SearchComponent(viewModel: NewsViewModel = hiltViewModel()) {
    var query by remember { mutableStateOf("") }

    var isFilterSelected by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        TextField(
            modifier =
            Modifier
                .weight(5f)
                .padding(end = 8.dp)
                .onFocusChanged {
                    isFilterSelected = !isFilterSelected
                },
            value = query,
            onValueChange = { newText ->
                query = newText
                coroutineScope.launch {
                    if (query.isNotEmpty()) {
                        viewModel.searchNews(query)
                    } else {
                        viewModel.getNewsList()
                    }
                }
            },
            shape = RoundedCornerShape(20.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = "search Icon",
                )
            },
            trailingIcon = {
                Icon(
                    if (isFilterSelected) Icons.Default.List else Icons.Default.Clear,
                    contentDescription = "clear text",
                    modifier = Modifier
                        .clickable {
                            coroutineScope.launch {
                                query = ""
                                viewModel.getNewsList()
                                isFilterSelected = !isFilterSelected
                            }
                        },
                )
            },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),

        )
    }
}
