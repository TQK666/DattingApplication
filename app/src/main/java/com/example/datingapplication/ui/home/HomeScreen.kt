package com.example.datingapplication.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = koinViewModel()
    val uiState by homeViewModel.uiState.collectAsState()
    HomeView(
        uiState = uiState,
        removeLastProfile = homeViewModel::removeLastProfile,
        fetchProfiles = homeViewModel::fetchProfiles,
        swipeUser = homeViewModel::swipeUser,
        onCloseDialog = homeViewModel::closeDialog,
        onSendMessage = homeViewModel::sendMessage,
    )
}