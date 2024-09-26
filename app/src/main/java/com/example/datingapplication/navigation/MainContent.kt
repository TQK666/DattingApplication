package com.example.datingapplication.navigation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.datingapplication.ui.home.HomeScreen
import com.example.datingapplication.ui.home.HomeViewModel
import com.example.datingapplication.ui.theme.DattingTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun NavigationGraph() {
    DattingTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Routes.Home) {
            animatedComposable(Routes.Home, animationType = AnimationType.HOME) {
                HomeScreen()
            }
        }
    }
}

fun NavGraphBuilder.animatedComposable(
    route: String,
    animationType: AnimationType = AnimationType.SLIDE,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {
    composable(route, arguments, deepLinks,
        enterTransition = animationType.enterTransition,
        exitTransition = animationType.exitTransition,
        popEnterTransition = animationType.popEnterTransition,
        popExitTransition = animationType.popExitTransition,
        content = content
    )
}