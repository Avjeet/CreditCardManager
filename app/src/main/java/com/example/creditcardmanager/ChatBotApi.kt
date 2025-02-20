package com.example.creditcardmanager

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ChatBotApi {
    @POST("v1/chain/test/RAG_TEST_TATA_DOC_RAG_867/execute/abc?debug=false&logEvaluationMetrics=false")
    @Headers("accept: application/json", "Content-Type: application/json", "Authorization: O-Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJpZGVudGl0eU1hbmFnZXIiLCJ2ZXJzaW9uIjoiNC4wIiwidGlkIjoiZmUwNzQwODktNTA0NS00NjNmLWExMzctMjk3NTBmYWEwMTEwIiwic2lkIjoiYTEzMWZhMzctZDY2Mi00YzZjLWIwNjktZDljMjkxZDIzNDEwIiwiaWF0IjoxNzQwMDU3NTI2LCJleHAiOjE3NDA2NjIzMjZ9.jXRIpGef71SeR6WMiixH_mJexWLoMb5D6N34cUYqP-jyNSF_mT8yhYXJTpDumgWXOSP3n5aiiG8NZgN5St95Gg")
    fun executeRagRequest(
        @Body requestBody: ChatRequest
    ): Call<ChatResponse>
}