package com.example.navegaofluxotelas

import android.R.attr.name
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegaofluxotelas.screens.LoginScreen
import com.example.navegaofluxotelas.screens.MenuScreen
import com.example.navegaofluxotelas.screens.PedidosScreen
import com.example.navegaofluxotelas.screens.PerfilScreen
import com.example.navegaofluxotelas.ui.theme.NavegaçãoFluxoTelasTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegaçãoFluxoTelasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            ) + fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            )
                        }
                    ) {
                        composable(
                            route = "login",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(1000)
                                )
                            }
                        ) {
                            LoginScreen(
                                modifier = Modifier.padding(
                                    innerPadding
                                ), navController
                            )
                        }

                        composable(route = "menu") {
                            MenuScreen(
                                modifier = Modifier.padding(
                                    innerPadding
                                ), navController
                            )
                        }

                        composable(
                            route = "pedidos?numeroPedido={numeroPedido}",
                            arguments = listOf(
                                navArgument(name = "numeroPedido") {
                                    defaultValue = "Sem pedido"
                                }
                            )) {
                            val numeroPedido = it.arguments?.getString("numeroPedido")
                            PedidosScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController,
                                numeroPedido = numeroPedido!!
                            )
                        }

                        composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument(name = "nome") {
                                    type = NavType.StringType
                                },
                                navArgument(name = "idade") {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            val nome = it.arguments?.getString("nome")
                            val idade = it.arguments?.getInt("idade")
                            PerfilScreen(
                                modifier = Modifier.padding(innerPadding),
                                navController,
                                nome = nome!!,
                                idade = idade!!
                            )
                        }

                    }
                }
            }
        }
    }
}

