package com.ryunen344.hilt.uniflow.home

import com.ryunen344.hilt.uniflow.model.Repository
import io.uniflow.core.flow.data.UIState

data class RepositoryState(val repositoryList: List<Repository>) : UIState()
