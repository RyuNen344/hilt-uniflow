package com.ryunen344.hilt.uniflow.api.github

import com.ryunen344.hilt.uniflow.api.github.response.RepositoryItemResponse
import com.ryunen344.hilt.uniflow.api.github.response.RepositoryResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url
import io.ktor.http.ContentType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.builtins.list
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlin.coroutines.CoroutineContext

class GitHubApi(
    private val httpClient: HttpClient,
    private val apiEndpoint: String,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) {
    private val json = Json(JsonConfiguration.Stable)

    @ImplicitReflectionSerializer
    suspend fun getRepositories(since: Int?): RepositoryResponse = withContext(coroutineContext) {
        val rawResponse = httpClient.get<String> {
            header("Connection", "close")
            url(if (since != null) "$apiEndpoint/repositories?since=$since" else "$apiEndpoint/repositories")
            accept(ContentType.Application.Json)
        }

        RepositoryResponse(
            json.parse(
                RepositoryItemResponse.serializer().list,
                rawResponse
            )
        )
    }
}
