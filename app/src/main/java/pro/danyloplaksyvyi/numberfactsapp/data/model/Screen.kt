package pro.danyloplaksyvyi.numberfactsapp.data.model

sealed class Screen(val route: String) {
    data object Main: Screen("main")
    data object Details: Screen("details")
}