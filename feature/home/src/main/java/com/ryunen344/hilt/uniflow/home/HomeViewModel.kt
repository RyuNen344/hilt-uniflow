package com.ryunen344.hilt.uniflow.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ryunen344.hilt.uniflow.repository.github.GitHubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.ImplicitReflectionSerializer

class HomeViewModel @ViewModelInject constructor(
    gitHubRepository: GitHubRepository
) : ViewModel() {

    @ImplicitReflectionSerializer
    val repositories =
        gitHubRepository.getRepositoryList(null)
            .asLiveData(Dispatchers.Default + viewModelScope.coroutineContext)
}
