package pro.danyloplaksyvyi.numberfactsapp.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(onDetailsNavigate: (Long) -> Unit) {
    Column {
        Text("MainScreen")
        Button(onClick = { onDetailsNavigate(1) }) {
            Text("Go to Details")
        }
    }
}