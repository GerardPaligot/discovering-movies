package com.paligot.movies.presentation.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Idea(
    code: @Composable () -> Unit,
    preview: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxSize().background(color = Color(0xFF35383b)),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(modifier = Modifier.weight(.7f)) {
            code()
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(.4f)
                .fillMaxHeight()
                .background(color = Color(0xFF2e2f31))
        ) {
            preview()
        }
    }
}
