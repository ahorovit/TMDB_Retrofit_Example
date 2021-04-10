package com.drspaceman.tmdb_retrofit_example.data

data class TmdbConfig(
    val secure_base_url: String,
    val poster_sizes: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TmdbConfig

        if (secure_base_url != other.secure_base_url) return false
        if (!poster_sizes.contentEquals(other.poster_sizes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = secure_base_url.hashCode()
        result = 31 * result + poster_sizes.contentHashCode()
        return result
    }
}

data class TmdbConfigResponse(
    val images: TmdbConfig
)