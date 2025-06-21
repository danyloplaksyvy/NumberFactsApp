package pro.danyloplaksyvyi.numberfactsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pro.danyloplaksyvyi.numberfactsapp.data.model.Screen
import pro.danyloplaksyvyi.numberfactsapp.presentation.view.DetailsScreen
import pro.danyloplaksyvyi.numberfactsapp.presentation.view.MainScreen

@Composable
fun NumberFactsNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(route = Screen.Main.route) {
            MainScreen { num -> navController.navigate("${Screen.Details.route}/$num") }
        }
        composable(route = "${Screen.Details.route}/{num}") { backStackEntry ->
            val num = backStackEntry.arguments?.getString("num")?.toLongOrNull() ?: 0L
            DetailsScreen(num = num)
        }
    }
}