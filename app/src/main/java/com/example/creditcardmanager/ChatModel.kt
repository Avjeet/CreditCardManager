package com.example.creditcardmanager


data class ChatRequest(val userMessage: String)

data class ChatResponse(val content: String)

data class ChatMessage(val message: String, val isUser: Boolean = false)
