package com.ryunen344.hilt.uniflow.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.ryunen344.hilt.uniflow.core.autoCleared
import com.ryunen344.hilt.uniflow.home.databinding.FragmentHomeBinding
import com.ryunen344.hilt.uniflow.model.Repository
import dagger.hilt.android.AndroidEntryPoint
import io.uniflow.android.flow.onStates
import io.uniflow.core.flow.data.UIState
import kotlinx.serialization.ImplicitReflectionSerializer

@AndroidEntryPoint
@ImplicitReflectionSerializer
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var binding: FragmentHomeBinding by autoCleared()

    private val homeViewModel: HomeViewModel by viewModels()

    @ImplicitReflectionSerializer
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.bind(view)

        binding.toolbar.setupWithNavController(findNavController())

        viewLifecycleOwner.onStates(homeViewModel) { state ->
            when (state) {
                is UIState.Loading -> {
                    showLoading()
                }

                is RepositoryState -> {
                    updateList(state.repositoryList)
                }

                is UIState.Failed  -> {
                    showSnackBar("${state.error}")
                }
            }
        }
    }

    private fun showLoading() {
        binding.progress.visibility = View.VISIBLE
    }

    private fun updateList(list: List<Repository>) {
        binding.progress.visibility = View.GONE
        binding.list.repositories = list
    }

    private fun showSnackBar(message: String) {
        binding.progress.visibility = View.GONE
        Snackbar.make(binding.list, "Error :: $message", Snackbar.LENGTH_INDEFINITE)
            .setAnimationMode(Snackbar.ANIMATION_MODE_FADE)
            .setAction("retry") {
                homeViewModel.getRepositoryList()
            }
            .show()
    }
}
