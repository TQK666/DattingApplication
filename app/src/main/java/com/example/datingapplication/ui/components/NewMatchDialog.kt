package com.example.datingapplication.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.datingapplication.model.ProfilePictureState
import com.example.datingapplication.ui.home.NewMatchView

@Composable
fun NewMatchDialog(
    pictureStates: List<ProfilePictureState>,
    onCloseClicked: () -> Unit) {
    Dialog(onDismissRequest = onCloseClicked, properties = DialogProperties(usePlatformDefaultWidth = false)) {
        NewMatchView(pictureStates, onCloseClicked)
    }
}