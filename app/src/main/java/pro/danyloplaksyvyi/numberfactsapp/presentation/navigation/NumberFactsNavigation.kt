package pro.danyloplaksyvyi.numberfactsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pro.danyloplaksyvyi.numberfactsapp.domain.model.Screen
import pro.danyloplaksyvyi.numberfactsapp.presentation.detail.view.DetailsScreen
import pro.danyloplaksyvyi.numberfactsapp.presentation.main.view.MainScreen

@Composable
fun NumberFactsNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.Main.route, modifier = modifier) {
        composable(route = Screen.Main.route) {
            MainScreen(onNavigateToDetail =  { factId -> navController.navigate("${Screen.Details.route}/$factId") })
        }
        composable(route = "${Screen.Details.route}/{factId}") { backStackEntry ->
            val factId = backStackEntry.arguments?.getString("factId")?.toLongOrNull() ?: 0L
            DetailsScreen(
                factId = factId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}