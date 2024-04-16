package com.example.kotlincomposefirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlincomposefirstapp.navigation.RootNavigationGraph
import com.example.kotlincomposefirstapp.ui.theme.KotlinComposeFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           KotlinComposeFirstApp()
        }
    }
}

@Composable
fun KotlinComposeFirstApp() {
    KotlinComposeFirstAppTheme {
       RootNavigationGraph(navController = rememberNavController())
    }
}
