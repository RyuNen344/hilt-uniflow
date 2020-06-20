package com.ryunen344.hilt.uniflow.repository

import com.ryunen344.hilt.uniflow.repository.github.GitHubRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { GitHubRepository(get()) }
}
