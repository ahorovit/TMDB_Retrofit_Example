package com.drspaceman.tmdb_retrofit_example.data

data class TmdbMovie(
        val id: Int,
        val vote_average: Double,
        val title: String,
        val release_date: String,
        val overview: String,
        val adult: Boolean,
        val poster_path: String?
) {
        fun getPosterUrl(fileSize: String = THUMBNAIL): String? {
                if (imgBaseUrl == null) {
                        return null
                }

                var fileSize = "w300"

                return "$imgBaseUrl$fileSize$poster_path"


                /*
                ex https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg

                base_url = https://image.tmdb.org/t/p/ (from configuration API)
                file_size = w500
                file_path = /kqjL17yufvn9OVLyXYpvtyrFfak.jpg

                 */
        }

        // Image urls depend on API configuration results
        companion object {
                const val THUMBNAIL = "thumbnail"
                const val LARGE = "large"

                var imgBaseUrl: String? = null
                var posterSizes: Array<String>? = null
        }
}

data class TmdbMovieListResponse(
        val results: List<TmdbMovie>
)

data class TmdbMovieResponse(
        val result: TmdbMovie
)