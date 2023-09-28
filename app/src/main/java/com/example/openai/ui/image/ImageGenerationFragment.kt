package com.example.openai.ui.image

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openai.R
import com.example.openai.databinding.ImageGenerationFragmentBinding
import com.example.openai.ui.base.BaseAdapter
import com.example.openai.ui.base.BaseFragment
import com.example.openai.ui.chat.ChatAdapter
import com.example.openai.utilites.collectLast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ImageGenerationFragment :BaseFragment<ImageGenerationFragmentBinding>() {
    override val layoutFragmentId: Int = R.layout.image_generation_fragment
    override val viewModel: ImageGeneratorViewModel by viewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        collectLast(viewModel.state) {
                val imageGeneratorAdapter = ImageGeneratorAdapter(it.list.toList())
                imageGeneratorAdapter.setItems(it.list.toList())
                binding.recyclerView.adapter = imageGeneratorAdapter
                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

    }
}