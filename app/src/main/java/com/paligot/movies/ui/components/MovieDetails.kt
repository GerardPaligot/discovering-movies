package com.paligot.movies.ui.components

import android.content.res.Configuration
import androidx.compose.animation.animate
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRowForIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AmbientEmphasisLevels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideEmphasis
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Devices
import androidx.ui.tooling.preview.Preview
import com.paligot.movies.data.Movie
import com.paligot.movies.data.MovieDetail
import com.paligot.movies.data.MovieViewModel
import com.paligot.movies.data.joker
import com.paligot.movies.extensions.formatDate
import com.paligot.movies.ui.ExploringMoviesTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import java.util.*

@Composable
fun MovieDetailsViewModel(
  movieId: Int,
  onClick: (movie: Movie) -> Unit
) {
  val viewModel: MovieViewModel = viewModel()
  val movie = viewModel.getMovieDetail(movieId).collectAsState(initial = null)
  movie.value?.let {
    MovieDetails(movie = it, onClick = onClick)
  }
}

@Composable
fun MovieDetails(
  movie: MovieDetail,
  backdropHeight: Dp = 300.dp,
  corner: Dp = 20.dp,
  startPaddingPoster: Dp = 30.dp,
  widthPosterSize: Dp = 130.dp,
  heightPosterSize: Dp = 180.dp,
  ratingSize: Dp = 50.dp,
  onClick: (movie: Movie) -> Unit
) {
  Box {
    val scrollState = rememberScrollState(0f)
    CoilImage(
      data = movie.backdrop,
      modifier = Modifier.fillMaxWidth().height(backdropHeight),
      contentScale = ContentScale.FillHeight
    )
    ScrollableColumn(scrollState = scrollState) {
      Spacer(modifier = Modifier.height((backdropHeight - corner)).fillMaxWidth())
      Surface(
        shape = RoundedCornerShape(topLeft = corner, topRight = corner),
        elevation = 5.dp
      ) {
        Box(modifier = Modifier.fillMaxSize()) {
          val startPaddingHeader = widthPosterSize + startPaddingPoster
          val dynamicStartPaddingHeader = (startPaddingHeader.value - (scrollState.value / 2.5f))
            .coerceIn(startPaddingPoster.value, startPaddingHeader.value)
          Box(
            modifier = Modifier.padding(
              start = dynamicStartPaddingHeader.dp,
              top = ratingSize / 2
            )
          ) {
            MovieMetadata(
              title = movie.title,
              genres = movie.genres,
              releaseDate = movie.releaseDate,
              runtime = movie.runtime
            )
          }
          Column(
            modifier = Modifier.padding(top = heightPosterSize - 50.dp + 20.dp)
          ) {
            OverviewSection(startPaddingPoster, movie)
            ActorsSection(startPaddingPoster, movie)
            if (movie.recommendations.isNotEmpty())
              RecommendationSection(startPaddingPoster, movie, onClick)
            if (movie.similar.isNotEmpty())
              SimilarSection(startPaddingPoster, movie, onClick)
          }
        }
      }
    }
    val topPaddingPoster = backdropHeight - corner - 50.dp
    val opacity = ((widthPosterSize.value * 2) - scrollState.value) / widthPosterSize.value
    Box(
      modifier = Modifier
        .padding(
          start = startPaddingPoster,
          top = Dp(
            (topPaddingPoster.value - (scrollState.value / 1.5f))
              .coerceIn(0f, topPaddingPoster.value)
          )
        )
        .width(widthPosterSize)
        .aspectRatio(0.7f)
        .drawOpacity(animate(opacity))
    ) {
      PosterNoted(
        posterUrl = movie.poster,
        voteAverage = movie.voteAverage,
        ratingSize = ratingSize,
        ratingAlignment = Alignment.TopEnd
      )
    }
  }
}

@Composable
private fun OverviewSection(
  startPaddingPoster: Dp,
  movie: MovieDetail
) {
  DetailSection(
    title = "Overview",
    modifier = Modifier.padding(start = startPaddingPoster)
  ) {
    Text(
      text = movie.overview,
      modifier = Modifier.padding(
        start = startPaddingPoster,
        end = 10.dp
      )
    )
  }
}

@Composable
private fun ActorsSection(
  startPaddingPoster: Dp,
  movie: MovieDetail
) {
  DetailSection(
    title = "Actors",
    modifier = Modifier.padding(
      start = startPaddingPoster,
      top = 20.dp
    )
  ) {
    ScrollableRow {
      movie.actors.forEachIndexed { index, it ->
        ActorItem(
          name = it.name,
          pictureUrl = it.profilePath,
          modifier = Modifier
            .padding(
              top = 5.dp,
              bottom = 5.dp,
              end = 5.dp,
              start = if (index == 0) startPaddingPoster else 5.dp
            )
            .preferredWidth(100.dp)
        )
      }
    }
  }
}

@Composable
private fun RecommendationSection(
  startPaddingPoster: Dp,
  movie: MovieDetail,
  onClick: (movie: Movie) -> Unit
) {
  DetailSection(
    title = "Recommendations",
    modifier = Modifier.padding(start = startPaddingPoster, top = 20.dp)
  ) {
    LazyRowForIndexed(items = movie.recommendations) { index, it ->
      Box(
        modifier = Modifier.padding(
          start = if (index == 0) startPaddingPoster else 0.dp,
          end = 5.dp, top = 5.dp, bottom = 5.dp
        )
      ) {
        Poster(
          pictureUrl = it.pictureUrl,
          width = 120.dp,
          height = 180.dp
        ) { onClick(it) }
      }
    }
  }
}

@Composable
private fun SimilarSection(
  startPaddingPoster: Dp,
  movie: MovieDetail,
  onClick: (movie: Movie) -> Unit
) {
  DetailSection(
    title = "Similar",
    modifier = Modifier.padding(start = startPaddingPoster, top = 20.dp)
  ) {
    LazyRowForIndexed(items = movie.similar) { index, it ->
      Box(
        modifier = Modifier.padding(
          start = if (index == 0) startPaddingPoster else 0.dp,
          end = 5.dp, top = 5.dp, bottom = 5.dp
        )
      ) {
        Poster(
          pictureUrl = it.pictureUrl,
          width = 120.dp,
          height = 180.dp
        ) { onClick(it) }
      }
    }
  }
}

@Composable
fun MovieMetadata(
  title: String,
  genres: List<String>,
  releaseDate: String,
  runtime: Int,
  modifier: Modifier = Modifier
) {
  Column(modifier = modifier) {
    Text(
      text = title,
      style = MaterialTheme.typography.h6,
      maxLines = 2,
      overflow = TextOverflow.Ellipsis
    )
    Row(modifier = Modifier.padding(top = 5.dp)) {
      genres.take(3).forEach {
        Tag(text = it)
      }
    }
    ProvideEmphasis(emphasis = AmbientEmphasisLevels.current.medium) {
      val year = releaseDate.formatDate().get(Calendar.YEAR)
      val time = "${runtime / 60}h ${runtime % 60}min"
      Text(
        text = if (runtime != 0) "$year - $time" else "$year",
        modifier = Modifier.padding(top = 5.dp)
      )
    }
  }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MovieMetadataPreview() {
  ExploringMoviesTheme(isDarkMode = true) {
    Surface(modifier = Modifier.fillMaxSize()) {
      MovieMetadata(
        title = joker.title,
        genres = joker.genres,
        releaseDate = joker.releaseDate,
        runtime = joker.runtime,
        modifier = Modifier
          .wrapContentWidth(align = Alignment.CenterHorizontally)
          .wrapContentHeight(align = Alignment.CenterVertically)
      )
    }
  }
}

@Composable
fun DetailSection(
  title: String,
  modifier: Modifier,
  content: @Composable () -> Unit
) {
  Column {
    Text(
      text = title,
      style = MaterialTheme.typography.overline.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.W700
      ),
      modifier = modifier
    )
    content()
  }
}

@Preview(device = Devices.PIXEL_4, showDecoration = true)
@Composable
fun MovieDetailsPreview() {
  ExploringMoviesTheme() {
    MovieDetails(joker) {}
  }
}