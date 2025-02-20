package com.example.creditcardmanager


import androidx.compose.runtime.mutableStateOf
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class ChatViewModel: ViewModel() {
    private val _chatMessages = mutableStateOf(listOf<ChatMessage>())
    val chatMessages: State<List<ChatMessage>> = _chatMessages

    private val _loadingState = mutableStateOf(false)
    val loadingState: State<Boolean> = _loadingState

    fun sendMessage(userInput: String) {
        _chatMessages.value = listOf(ChatMessage("You: $userInput", true)) + _chatMessages.value

        val chatRequest = ChatRequest(userInput)
        val api = RetrofitClient.instance
        val call = api.executeRagRequest(
            chatRequest
        )

        _loadingState.value = true

        call.enqueue(object : Callback<ChatResponse> {
            override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
                _loadingState.value = false
                if (response.isSuccessful) {
                    val botMessage = response.body()?.content ?: "Sorry, I didn't understand that."
                    _chatMessages.value = listOf(ChatMessage("Bot: $botMessage")) + _chatMessages.value
                } else {
                    _chatMessages.value = listOf(ChatMessage("Error: ${response.message()}")) + _chatMessages.value
                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                _loadingState.value = false
                _chatMessages.value = listOf(ChatMessage("Error: ${t.message}")) + _chatMessages.value
            }
        })
    }
}