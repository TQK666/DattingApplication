package com.example.domain.usecase

import com.example.domain.picture.PictureRepository

class GetPictureUseCase(private val pictureRepository: PictureRepository) {
    suspend operator fun invoke(userId: String, pictureName: String): Result<String> {
        return Result.runCatching { pictureRepository.getPicture(userId, pictureName) }
    }
}