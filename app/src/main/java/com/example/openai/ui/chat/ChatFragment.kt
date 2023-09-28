package com.example.openai.ui.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openai.R
import com.example.openai.ui.base.BaseFragment
import com.example.openai.databinding.ChatFragmentBinding
import com.example.openai.utilites.collectLast

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : BaseFragment<ChatFragmentBinding>() {

    override val layoutFragmentId: Int = R.layout.chat_fragment
    override val viewModel: ChatCompletionViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        collectLast(viewModel.state){
            val chatAdapter = ChatAdapter(it.list.toList())
            chatAdapter.setItems(it.list.toList())
            binding.recyclerView.adapter = chatAdapter
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}