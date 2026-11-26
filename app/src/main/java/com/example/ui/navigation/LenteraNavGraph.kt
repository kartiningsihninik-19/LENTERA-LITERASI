package com.example.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.automirrored.outlined.MenuBook
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.outlined.EditNote
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.screens.BerandaScreen
import com.example.ui.screens.KuisScreen
import com.example.ui.screens.MateriDetailScreen
import com.example.ui.screens.PraktikScreen
import com.example.ui.screens.PustakaScreen
import com.example.ui.screens.ReaderScreen
import com.example.ui.viewmodel.LenteraViewModel

object LenteraRoutes {
    const val BERANDA = "beranda"
    const val PUSTAKA = "pustaka"
    const val PRAKTIK = "praktik"
    const val KUIS = "kuis"
    const val MATERI_DETAIL = "materi/{chapterId}"
    const val READER = "reader/{readingId}"

    fun materiDetail(chapterId: String) = "materi/$chapterId"
    fun reader(readingId: String) = "reader/$readingId"
}

private data class TopDestination(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

private val topDestinations = listOf(
    TopDestination(
        route = LenteraRoutes.BERANDA,
        label = "Beranda",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    TopDestination(
        route = LenteraRoutes.PUSTAKA,
        label = "Pustaka",
        selectedIcon = Icons.AutoMirrored.Filled.MenuBook,
        unselectedIcon = Icons.AutoMirrored.Outlined.MenuBook
    ),
    TopDestination(
        route = LenteraRoutes.PRAKTIK,
        label = "Praktik",
        selectedIcon = Icons.Filled.EditNote,
        unselectedIcon = Icons.Outlined.EditNote
    ),
    TopDestination(
        route = LenteraRoutes.KUIS,
        label = "Kuis",
        selectedIcon = Icons.Filled.Quiz,
        unselectedIcon = Icons.Outlined.Quiz
    )
)

@Composable
fun LenteraApp(
    viewModel: LenteraViewModel,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val isTopLevel = topDestinations.any { it.route == currentRoute }

    fun navigateToTopLevel(route: String) {
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val useNavRail = maxWidth >= 600.dp

        Scaffold(
            contentWindowInsets = WindowInsets.safeDrawing,
            containerColor = MaterialTheme.colorScheme.background,
            bottomBar = {
                if (isTopLevel && !useNavRail) {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerLow
                    ) {
                        topDestinations.forEach { dest ->
                            val selected = currentRoute == dest.route
                            NavigationBarItem(
                                selected = selected,
                                onClick = { navigateToTopLevel(dest.route) },
                                icon = {
                                    Icon(
                                        imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                        contentDescription = dest.label
                                    )
                                },
                                label = { Text(dest.label) },
                                modifier = Modifier.testTag("nav_${dest.route}")
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                if (isTopLevel && useNavRail) {
                    NavigationRail(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerLow
                    ) {
                        topDestinations.forEach { dest ->
                            val selected = currentRoute == dest.route
                            NavigationRailItem(
                                selected = selected,
                                onClick = { navigateToTopLevel(dest.route) },
                                icon = {
                                    Icon(
                                        imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                        contentDescription = dest.label
                                    )
                                },
                                label = { Text(dest.label) },
                                modifier = Modifier.testTag("rail_${dest.route}")
                            )
                        }
                    }
                }

                Box(modifier = Modifier.weight(1f).fillMaxSize()) {
                    NavHost(
                        navController = navController,
                        startDestination = LenteraRoutes.BERANDA
                    ) {
                        composable(LenteraRoutes.BERANDA) {
                            BerandaScreen(
                                viewModel = viewModel,
                                onOpenChapter = { chapterId ->
                                    navController.navigate(LenteraRoutes.materiDetail(chapterId))
                                },
                                onOpenReading = { readingId ->
                                    navController.navigate(LenteraRoutes.reader(readingId))
                                },
                                onExploreCategory = { category ->
                                    viewModel.selectCategory(category)
                                    navigateToTopLevel(LenteraRoutes.PUSTAKA)
                                },
                                onOpenPraktik = {
                                    navigateToTopLevel(LenteraRoutes.PRAKTIK)
                                }
                            )
                        }

                        composable(LenteraRoutes.PUSTAKA) {
                            PustakaScreen(
                                viewModel = viewModel,
                                onOpenReading = { readingId ->
                                    navController.navigate(LenteraRoutes.reader(readingId))
                                }
                            )
                        }

                        composable(LenteraRoutes.PRAKTIK) {
                            PraktikScreen(viewModel = viewModel)
                        }

                        composable(LenteraRoutes.KUIS) {
                            KuisScreen(viewModel = viewModel)
                        }

                        composable(
                            route = LenteraRoutes.MATERI_DETAIL,
                            arguments = listOf(navArgument("chapterId") { type = NavType.StringType })
                        ) { entry ->
                            val chapterId = entry.arguments?.getString("chapterId").orEmpty()
                            MateriDetailScreen(
                                chapter = viewModel.getChapterById(chapterId),
                                onBack = { navController.popBackStack() },
                                onStartQuizForChapter = { topicId, title ->
                                    viewModel.startQuiz(topicId, title)
                                    navigateToTopLevel(LenteraRoutes.KUIS)
                                }
                            )
                        }

                        composable(
                            route = LenteraRoutes.READER,
                            arguments = listOf(navArgument("readingId") { type = NavType.StringType })
                        ) { entry ->
                            val readingId = entry.arguments?.getString("readingId").orEmpty()
                            ReaderScreen(
                                passage = viewModel.getReadingById(readingId),
                                viewModel = viewModel,
                                onBack = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}
