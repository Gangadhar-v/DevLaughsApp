package com.example.devlaughs

data class JokeResponse(
    val amount: Int,
    val error: Boolean,
    val jokes: List<Joke>
)