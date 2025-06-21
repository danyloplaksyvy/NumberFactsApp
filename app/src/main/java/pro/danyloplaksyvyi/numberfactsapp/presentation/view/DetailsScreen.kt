package pro.danyloplaksyvyi.numberfactsapp.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailsScreen(num: Long) {
    Column() {
        Text("Details Screen")
        Text("$num")
    }
}