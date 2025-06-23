package pro.danyloplaksyvyi.numberfactsapp.domain.model

sealed class Screen(val route: String) {
    data object Main: Screen("main")
    data object Details: Screen("details")
}