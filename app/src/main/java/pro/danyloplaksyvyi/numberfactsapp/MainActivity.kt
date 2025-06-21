package pro.danyloplaksyvyi.numberfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import pro.danyloplaksyvyi.numberfactsapp.presentation.navigation.NumberFactsNavigation
import pro.danyloplaksyvyi.numberfactsapp.ui.theme.NumberFactsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NumberFactsAppTheme {
                Scaffold { innerPadding ->
                    NumberFactsNavigation(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}