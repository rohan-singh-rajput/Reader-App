package com.rohan.areader.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.rohan.areader.presentation.navigation.screens.home.ReaderHomeScreen
import com.rohan.areader.presentation.navigation.screens.login.ReaderLoginScreen
import com.rohan.areader.presentation.navigation.screens.ReaderSplashScreen
import com.rohan.areader.presentation.navigation.screens.search.SearchScreen
import com.rohan.areader.presentation.navigation.screens.stats.ReaderStatsScreen


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ReaderNavigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = ReaderScreens.SplashScreen.name
    ) {
        composable(ReaderScreens.SplashScreen.name,
            enterTransition = {
                when (initialState.destination.route) {
                    "Red" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = spring(
                                stiffness = Spring.StiffnessMediumLow,
                                visibilityThreshold = IntOffset.VisibilityThreshold
                            ),
                            initialOffset = {
                                -it / 2
                            }
                        )
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    "Red" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    "Red" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    "Red" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            }) {
            ReaderSplashScreen(navController = navController)
        }

        composable(ReaderScreens.ReaderHomeScreen.name,
            enterTransition = {
                when (initialState.destination.route) {
                    "Red" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = spring(
                                stiffness = Spring.StiffnessMediumLow,
                                visibilityThreshold = IntOffset.VisibilityThreshold
                            ),
                            initialOffset = {
                                -it / 2
                            }
                        )
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    "Red" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    "Red" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    "Red" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            }) {
            ReaderHomeScreen(navController = navController)
        }

        composable(ReaderScreens.LoginScreen.name,
            enterTransition = {
                when (initialState.destination.route) {
                    "Red" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = spring(
                                stiffness = Spring.StiffnessMediumLow,
                                visibilityThreshold = IntOffset.VisibilityThreshold
                            ),
                            initialOffset = {
                                -it / 2
                            }
                        )
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    "Red" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    "Red" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    "Red" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            }) {
            ReaderLoginScreen(navController = navController)
        }

        composable(ReaderScreens.ReaderStatsScreen.name,
            enterTransition = {
                when (initialState.destination.route) {
                    "Red" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = spring(
                                stiffness = Spring.StiffnessMediumLow,
                                visibilityThreshold = IntOffset.VisibilityThreshold
                            ),
                            initialOffset = {
                                -it / 2
                            }
                        )
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    "Red" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    "Red" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    "Red" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            }) {
            ReaderStatsScreen(navController = navController)
        }

        composable(
            ReaderScreens.SearchScreen.name,
            enterTransition = {
                when (initialState.destination.route) {
                    "Red" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = spring(
                                stiffness = Spring.StiffnessMediumLow,
                                visibilityThreshold = IntOffset.VisibilityThreshold
                            ),
                            initialOffset = {
                                -it / 2
                            }
                        )
                    else -> null
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    "Red" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Left,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            },
            popEnterTransition = {
                when (initialState.destination.route) {
                    "Red" ->
                        slideIntoContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            },
            popExitTransition = {
                when (targetState.destination.route) {
                    "Red" ->
                        slideOutOfContainer(
                            AnimatedContentScope.SlideDirection.Right,
                            animationSpec = tween(700)
                        )
                    else -> null
                }
            }) {
            SearchScreen(navController = navController)
        }


    }
}

