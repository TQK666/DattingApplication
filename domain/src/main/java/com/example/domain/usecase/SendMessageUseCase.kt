package com.example.domain.usecase

import com.example.domain.message.MessageRepository


class SendMessageUseCase(private val messageRepository: MessageRepository) {

    suspend operator fun invoke(matchId: String, message: String): Result<Unit> {
        return Result.runCatching { messageRepository.addMessage(matchId, message) }
    }
}