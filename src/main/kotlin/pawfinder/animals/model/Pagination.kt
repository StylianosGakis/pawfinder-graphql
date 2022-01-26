package pawfinder.animals.model

data class Pagination(
    val countPerPage: Int,
    val currentPage: Int,
    val links: Links,
    val totalCount: Int,
    val totalPages: Int,
) {
    data class Links(
        val next: Next,
        val previous: Previous? = null,
    ) {
        data class Next(
            val href: String,
        )

        data class Previous(
            val href: String,
        )
    }
}
