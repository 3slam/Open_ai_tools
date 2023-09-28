package com.example.openai.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.openai.R
import com.example.openai.databinding.HomeFragmentBinding
import com.example.openai.ui.base.BaseFragment
import com.example.openai.utilites.collectLast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>() {
    override val layoutFragmentId = R.layout.home_fragment
    override val viewModel : HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        collectLast(viewModel.effect ){ uiEffect(it) }

    }

    private fun uiEffect(effect: HomeUiEffect) {
      when(effect){
          HomeUiEffect.NavigateToChat -> findNavController().navigate(R.id.action_home_to_chat)
          HomeUiEffect.NavigateToImageGeneration ->findNavController().navigate(R.id.action_home_to_image)
          HomeUiEffect.NavigateToTextClassification ->findNavController().navigate(R.id.action_home_to_textClassification)
      }
    }

}