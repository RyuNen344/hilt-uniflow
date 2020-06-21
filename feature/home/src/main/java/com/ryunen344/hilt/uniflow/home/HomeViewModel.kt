package com.ryunen344.hilt.uniflow.home

import androidx.hilt.lifecycle.ViewModelInject
import com.ryunen344.hilt.uniflow.repository.github.GitHubRepository
import io.uniflow.android.flow.AndroidDataFlow
import io.uniflow.core.flow.data.UIState
import kotlinx.serialization.ImplicitReflectionSerializer

@ImplicitReflectionSerializer
class HomeViewModel @ViewModelInject constructor(
    private val gitHubRepository: GitHubRepository
) : AndroidDataFlow(defaultState = UIState.Empty) {

    init {
        getRepositoryList()
    }

    @ImplicitReflectionSerializer
    fun getRepositoryList() = action(
        onAction = {
            setState { UIState.Loading }
            val list = gitHubRepository.getRepositoryListOneShot()
            setState { RepositoryState(list) }
        },
        onError = { error, _ ->
            setState { UIState.Failed(message = null, error = error) }
        }
    )
}
