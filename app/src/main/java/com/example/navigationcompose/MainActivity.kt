package com.example.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationcompose.presentation.ScreenDetail
import com.example.navigationcompose.presentation.ScreenHome
import com.example.navigationcompose.presentation.ScreenLogin
import com.example.navigationcompose.presentation.ScreenStateProduct
import com.example.navigationcompose.presentation.model.Routes
import com.example.navigationcompose.ui.theme.NavigationComposeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationComposeTheme {
                val navigationController = rememberNavController()
                NavHost(
                    navController = navigationController,
                    startDestination = Routes.ScreenLogin.route
                ) {
                    composable(Routes.ScreenLogin.route) { ScreenLogin(navigationController) }
                    composable(Routes.ScreenHome.route) { ScreenHome(navigationController) }
                    composable(Routes.ScreenDetail.route, arguments =
                        listOf(navArgument("id") { type = NavType.IntType }))
                            {
                                backStackEntry -> ScreenDetail(navigationController, backStackEntry.arguments?.getInt("id") ?: 0)
                            }
                    composable(Routes.ScreenStateProduct.route, arguments =
                        listOf(navArgument("status") { defaultValue = "STOCK ERROR!" }))
                            {
                                backStackEntry -> ScreenStateProduct(navigationController = navigationController, backStackEntry.arguments?.getString("state"))
                            }
                }
            }

        }
    }
}


