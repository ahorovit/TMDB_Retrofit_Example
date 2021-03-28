package com.drspaceman.tmdb_retrofit_example.data

data class TmdbConfig(
    val base_url: String,
    val poster_sizes: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TmdbConfig

        if (base_url != other.base_url) return false
        if (!poster_sizes.contentEquals(other.poster_sizes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = base_url.hashCode()
        result = 31 * result + poster_sizes.contentHashCode()
        return result
    }
}

data class TmdbConfigResponse(
    val result: TmdbConfig
)