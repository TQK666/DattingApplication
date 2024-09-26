package com.example.data.source

import android.content.Context
import android.net.Uri
import com.example.data.R
import com.example.data.source.extension.resourceUri
import com.example.data.repository.picture.PictureRemoteDataSource
import kotlinx.coroutines.delay
import kotlin.random.Random

class PictureDataSourceImpl(private val context: Context): PictureRemoteDataSource {
    override suspend fun addPictures(localPictures: List<Uri>): List<String> {
        delay(1000)
        return localPictures.mapIndexed { _, i ->
            "picture$i.jpg"
        }
    }

    override suspend fun addPicture(localPicture: Uri): String {
        delay(1000)
        return "picture1.jpg"
    }

    override suspend fun deletePictures(pictureNames: List<String>) {
        delay(500)
    }

    override suspend fun getPicture(userId: String, pictureName: String): Uri {
        //The random delayed is used to showcase the picture asynchronous loading
        delay(Random.nextLong(1000, 4000))
        return when(pictureName){
            "woman_1.jpg" -> context.resourceUri(R.drawable.woman_1)
            "woman_2.jpg" -> context.resourceUri(R.drawable.woman_2)
            "woman_3.jpg" -> context.resourceUri(R.drawable.woman_3)
            "woman_4.jpg" -> context.resourceUri(R.drawable.woman_4)
            "woman_5.jpg" -> context.resourceUri(R.drawable.woman_5)
            "woman_6.jpg" -> context.resourceUri(R.drawable.woman_6)
            "woman_7.jpg" -> context.resourceUri(R.drawable.woman_7)
            "woman_8.jpg" -> context.resourceUri(R.drawable.woman_8)
            "woman_9.jpg" -> context.resourceUri(R.drawable.woman_9)
            "woman_10.jpg" -> context.resourceUri(R.drawable.woman_10)
            "woman_11.jpg" -> context.resourceUri(R.drawable.woman_11)
            "woman_12.jpg" -> context.resourceUri(R.drawable.woman_12)
            "woman_13.jpg" -> context.resourceUri(R.drawable.woman_13)
            "woman_14.jpg" -> context.resourceUri(R.drawable.woman_14)
            "woman_15.jpg" -> context.resourceUri(R.drawable.woman_15)
            "woman_16.jpg" -> context.resourceUri(R.drawable.woman_16)
            "woman_17.jpg" -> context.resourceUri(R.drawable.woman_17)
            "woman_18.jpg" -> context.resourceUri(R.drawable.woman_18)
            "woman_19.jpg" -> context.resourceUri(R.drawable.woman_19)
            "woman_20.jpg" -> context.resourceUri(R.drawable.woman_20)
            "woman_21.jpg" -> context.resourceUri(R.drawable.woman_21)
            "woman_22.jpg" -> context.resourceUri(R.drawable.woman_22)
            "woman_23.jpg" -> context.resourceUri(R.drawable.woman_23)
            "woman_24.jpg" -> context.resourceUri(R.drawable.woman_24)
            "woman_25.jpg" -> context.resourceUri(R.drawable.woman_25)
            "woman_26.jpg" -> context.resourceUri(R.drawable.woman_26)
            "woman_27.jpg" -> context.resourceUri(R.drawable.woman_27)
            "woman_28.jpg" -> context.resourceUri(R.drawable.woman_28)
            "woman_29.jpg" -> context.resourceUri(R.drawable.woman_29)
            "woman_30.jpg" -> context.resourceUri(R.drawable.woman_30)
            "woman_31.jpg" -> context.resourceUri(R.drawable.woman_31)
            "woman_32.jpg" -> context.resourceUri(R.drawable.woman_32)
            "woman_33.jpg" -> context.resourceUri(R.drawable.woman_33)
            "woman_34.jpg" -> context.resourceUri(R.drawable.woman_34)
            "woman_35.jpg" -> context.resourceUri(R.drawable.woman_35)
            "woman_36.jpg" -> context.resourceUri(R.drawable.woman_36)
            "woman_37.jpg" -> context.resourceUri(R.drawable.woman_37)
            "woman_38.jpg" -> context.resourceUri(R.drawable.woman_38)
            "woman_39.jpg" -> context.resourceUri(R.drawable.woman_39)
            "woman_40.jpg" -> context.resourceUri(R.drawable.woman_40)
            "woman_41.jpg" -> context.resourceUri(R.drawable.woman_41)
            "woman_42.jpg" -> context.resourceUri(R.drawable.woman_42)
            "woman_43.jpg" -> context.resourceUri(R.drawable.woman_43)
            else -> context.resourceUri(R.drawable.woman_1)
        }
    }
}