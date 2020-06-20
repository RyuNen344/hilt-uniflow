package com.ryunen344.hilt.uniflow.api.github.response

import kotlinx.serialization.Serializable

@Serializable
data class RepositoryResponse(
    val repositories: List<RepositoryItemResponse>
)
