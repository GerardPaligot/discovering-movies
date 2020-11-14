package com.paligot.movies.data

val movies = arrayListOf(
  Movie(
    title = "The Mandalorian",
    pictureUrl = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg",
    percentage = 84,
    genres = arrayListOf("Crime", "Thriller", "Drama"),
    releaseDate = "2019-10-02",
    runtime = 0
  ),
  Movie(
    title = "Flash",
    pictureUrl = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
    percentage = 70,
    genres = arrayListOf("Crime", "Thriller", "Drama"),
    releaseDate = "2019-10-02",
    runtime = 0
  ),
  Movie(
    title = "Mulan",
    pictureUrl = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/vMEmvfhCnuogg26mTxD50v0kE3u.jpg",
    percentage = 72,
    genres = arrayListOf("Crime", "Thriller", "Drama"),
    releaseDate = "2019-10-02",
    runtime = 0
  ),
  Movie(
    title = "The Boys",
    pictureUrl = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/dzOxNbbz1liFzHU1IPvdgUR647b.jpg",
    percentage = 74,
    genres = arrayListOf("Crime", "Thriller", "Drama"),
    releaseDate = "2019-10-02",
    runtime = 0
  ),
  Movie(
    title = "Joker",
    pictureUrl = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/zDyT3gIeae39UgL9P6jL5Zc3zyt.jpg",
    percentage = 82,
    genres = arrayListOf("Crime", "Thriller", "Drama"),
    releaseDate = "2019-10-02",
    runtime = 0
  ),
  Movie(
    title = "Coco",
    pictureUrl = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/gZifw6G1E0fbeR1FvyeLzdySt6m.jpg",
    percentage = 82,
    genres = arrayListOf("Crime", "Thriller", "Drama"),
    releaseDate = "2019-10-02",
    runtime = 0
  ),
  Movie(
    title = "L'Etrange Noel de Monsieur Jack",
    pictureUrl = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7Zi4LjI7KNfVDCq3tsiNhKt5xtS.jpg",
    percentage = 78,
    genres = arrayListOf("Crime", "Thriller", "Drama"),
    releaseDate = "2019-10-02",
    runtime = 0
  ),
  Movie(
    title = "La Famille Addams",
    pictureUrl = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lQwCnCOeQVUlWvZpfmtlFQjcfeW.jpg",
    percentage = 66,
    genres = arrayListOf("Crime", "Thriller", "Drama"),
    releaseDate = "2019-10-02",
    runtime = 0
  )
)

val joker = MovieDetail(
  title = "Joker",
  overview = "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
  backdrop = "https://image.tmdb.org/t/p/w780/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
  poster = "https://image.tmdb.org/t/p/w185/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
  voteAverage = 82,
  genres = arrayListOf("Crime", "Thriller", "Drama", "Crime", "Thriller", "Drama"),
  releaseDate = "2019-10-02",
  runtime = 122,
  actors = arrayListOf(
    Actor(
      "Joaquin Phoenix",
      "Arthur Fleck / Joker",
      "https://image.tmdb.org/t/p/w185/nXMzvVF6xR3OXOedozfOcoA20xh.jpg"
    ),
    Actor(
      "Robert De Niro",
      "Murray Franklin",
      "https://image.tmdb.org/t/p/w185/cT8htcckIuyI1Lqwt1CvD02ynTh.jpg"
    ),
    Actor(
      "Zazie Beetz",
      "Sophie Dumond",
      "https://image.tmdb.org/t/p/w185/sgxzT54GnvgeMnOZgpQQx9csAdd.jpg"
    ),
    Actor(
      "Frances Conroy",
      "Penny Fleck",
      "https://image.tmdb.org/t/p/w185/aJRQAkO24L6bH8qkkE5Iv1nA3gf.jpg"
    ),
    Actor(
      "Brett Cullen",
      "Thomas Wayne",
      "https://image.tmdb.org/t/p/w185/sEcPXqdcoZ9h4s7PSjVYocEPypP.jpg"
    ),
    Actor(
      "Shea Whigham",
      "Detective Burke",
      "https://image.tmdb.org/t/p/w185/d3caK3l4UfbnzOxv95wLoFLZzMO.jpg"
    ),
  ),
  recommendations = movies,
  similar = movies
)
