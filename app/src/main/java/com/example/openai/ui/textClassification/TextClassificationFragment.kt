package com.example.openai.ui.textClassification

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openai.R
import com.example.openai.databinding.TextClassificationFragmentBinding
import com.example.openai.ui.base.BaseFragment
import com.example.openai.ui.chat.ChatAdapter
import com.example.openai.utilites.collectLast
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.text_classification_fragment.view.textView3
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TextClassificationFragment :BaseFragment<TextClassificationFragmentBinding>() {
    override val layoutFragmentId= R.layout.text_classification_fragment
    override val viewModel: TextClassificationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

            collectLast(viewModel.state){
                val textClassificationAdapter = TextClassificationAdapter(it.list.toList())
                textClassificationAdapter.setItems(it.list.toList())
                binding.recyclerView.adapter = textClassificationAdapter
                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

}