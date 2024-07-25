package com.example.navigationcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.navigationcompose.presentation.model.Routes
import com.example.navigationcompose.presentation.model.Routes.ScreenHome

@Composable
fun ScreenLogin(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(text = "Pantalla Login", modifier = Modifier
            .align(Alignment.Center)
            .clickable {
                navigationController.navigate(ScreenHome.route)
            })
    }
}


@Composable
fun ScreenHome(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(text = "Pantalla Home", modifier = Modifier
            .align(Alignment.Center)
            .clickable {
                navigationController.navigate(Routes.ScreenDetail.createRoute(4))
            })
    }
}


@Composable
fun ScreenDetail(navigationController: NavHostController, id: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "Comprar producto com  id: ${id.toString()}",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(Routes.ScreenStateProduct.createRoute("Available"))
                })
    }
}


@Composable
fun ScreenStateProduct(navigationController: NavHostController, state: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(text = "Producto $state", modifier = Modifier.align(Alignment.Center))
    }
}