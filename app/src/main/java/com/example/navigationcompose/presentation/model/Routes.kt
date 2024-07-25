package com.example.navigationcompose.presentation.model

sealed class Routes( val route:String) {
    object ScreenLogin: Routes("screen_login")
    object ScreenHome: Routes("screen_home")
    object ScreenDetail: Routes("screen_detail/{id}"){
        fun createRoute(id: Int) = "screen_detail/$id"
    }
    object ScreenStateProduct: Routes("screen_state_product?state={state}"){
        fun createRoute(state: String ) = "screen_state_product?state=$state"
    }
}