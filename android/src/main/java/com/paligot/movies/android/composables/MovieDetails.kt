package com.paligot.movies.android.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage
import com.paligot.movies.components.ActorItem
import com.paligot.movies.components.MovieMetadata
import com.paligot.movies.components.Poster
import com.paligot.movies.components.PosterNoted
import com.paligot.movies.data.Movie
import com.paligot.movies.data.MovieDetail
import com.paligot.movies.data.joker
import com.paligot.movies.theming.ExploringMoviesTheme


const val startVelocity = 2.5f
const val topVelocity = 1.1f

@Composable
fun MovieDetails(
  movie: MovieDetail,
  onClick: (movie: Movie) -> Unit
) {
  val scrollState = rememberScrollState(0)
  // Fixed paddings
  val widthPosterSize = 130.dp
  val backdropHeight = 300.dp
  val corner = 8.dp
  val contentPadding = 16.dp
  val startPaddingHeader = widthPosterSize + contentPadding
  val topPaddingPoster = backdropHeight - corner - 50.dp
  // Dynamic paddings
  val dynamicStartPaddingHeader = (startPaddingHeader.value - (scrollState.value / startVelocity))
    .coerceIn(contentPadding.value, startPaddingHeader.value)
  val dynamicTopPaddingHeader = (topPaddingPoster.value - (scrollState.value / topVelocity))
    .coerceIn(0f, topPaddingPoster.value)
  val opacity = ((widthPosterSize.value * 2) - scrollState.value) / widthPosterSize.value
  Box(modifier = Modifier.background(color = MaterialTheme.colors.surface)) {
    CoilImage(
      data = movie.backdrop,
      modifier = Modifier
        .fillMaxWidth()
        .height(backdropHeight),
      contentScale = ContentScale.FillHeight,
      contentDescription = null
    )
    Column(Modifier.verticalScroll(scrollState)) {
      Spacer(
        modifier = Modifier
          .height(backdropHeight - corner)
          .fillMaxWidth()
      )
      Surface(shape = RoundedCornerShape(topStart = corner, topEnd = corner)) {
        Box(modifier = Modifier.fillMaxSize()) {
          MovieMetadata(
            title = movie.title,
            genres = movie.genres,
            releaseDate = movie.releaseDate,
            runtime = movie.runtime,
            modifier = Modifier.padding(
              start = dynamicStartPaddingHeader.dp,
              end = contentPadding,
              top = 25.dp
            )
          )
          Column(modifier = Modifier.padding(top = 150.dp)) {
            OverviewSection(movie)
            ActorsSection(movie)
            if (movie.recommendations.isNotEmpty()) RecommendationSection(movie, onClick)
            if (movie.similar.isNotEmpty()) SimilarSection(movie, onClick)
          }
        }
      }
    }
    PosterNoted(
      posterUrl = movie.poster,
      voteAverage = movie.voteAverage,
      ratingAlignment = Alignment.TopEnd,
      modifier = Modifier
        .padding(start = contentPadding, top = dynamicTopPaddingHeader.dp)
        .width(widthPosterSize)
        .alpha(opacity)
    )
  }
}

@Composable
private fun OverviewSection(movie: MovieDetail) {
  DetailSection(title = "Overview") { contentPadding ->
    Text(
      text = movie.overview,
      modifier = Modifier.padding(contentPadding)
    )
  }
}

@Composable
private fun ActorsSection(movie: MovieDetail) {
  DetailSection(title = "Actors") { contentPadding ->
    LazyRow(
      contentPadding = contentPadding,
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      items(movie.actors) {
        ActorItem(
          name = it.name,
          pictureUrl = it.profilePath,
          modifier = Modifier.width(100.dp)
        )
      }
    }
  }
}

@Composable
private fun RecommendationSection(
  movie: MovieDetail,
  onClick: (movie: Movie) -> Unit
) {
  DetailSection(title = "Recommendations") { contentPadding ->
    LazyRow(
      contentPadding = contentPadding,
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      items(movie.recommendations) {
        Poster(
          pictureUrl = it.pictureUrl,
          modifier = Modifier
            .width(100.dp)
            .clickable(onClick = { onClick(it) })
        )
      }
    }
  }
}

@Composable
private fun SimilarSection(
  movie: MovieDetail,
  onClick: (movie: Movie) -> Unit
) {
  DetailSection(title = "Similar") { contentPadding ->
    LazyRow(
      contentPadding = contentPadding,
      horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      items(movie.similar) {
        Poster(
          pictureUrl = it.pictureUrl,
          modifier = Modifier
            .width(100.dp)
            .clickable(onClick = { onClick(it) })
        )
      }
    }
  }
}

@Composable
private fun DetailSection(
  title: String,
  modifier: Modifier = Modifier,
  content: @Composable (paddingValue: PaddingValues) -> Unit
) {
  Column(modifier = modifier.padding(top = 16.dp)) {
    Text(
      text = title,
      style = MaterialTheme.typography.subtitle1,
      modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
    )
    content(PaddingValues(start = 16.dp, end = 16.dp))
  }
}

@Preview(device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun MovieDetailsPreview() {
  ExploringMoviesTheme(isDarkMode = true) {
    MovieDetails(joker) {}
  }
}
