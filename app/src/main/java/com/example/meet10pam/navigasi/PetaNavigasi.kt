package com.example.meet10pam.navigasi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.meet10pam.R
import com.example.meet10pam.ui.DestinasiEntry
import com.example.meet10pam.ui.DestinasiHome
import com.example.meet10pam.ui.DetailDestination
import com.example.meet10pam.ui.DetailScreen
import com.example.meet10pam.ui.EntrySiswaScreen
import com.example.meet10pam.ui.HomeScreen
import com.example.meet10pam.ui.ItemEditDestination
import com.example.meet10pam.ui.ItemEditScreen

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController()) {
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaToAppBar(
    title: String,
    canNavigasiBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) {
    CenterAlignedTopAppBar(title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigasiBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )

                }
            }
        }
    )
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToitemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = { itemId ->
                    navController.navigate("${DetailDestination.route}/$itemId")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(
            DetailDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailDestination.siswaIdArg) {
                type = NavType.IntType
            })
        ) {backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt(DetailDestination.siswaIdArg)
            itemId?.let{
                DetailScreen(
                    navigateBack = { navController.popBackStack() },
                    navigateToEditItem = {
                        navController.navigate("${ItemEditDestination.route}$it")
                    })
            }


        }

        composable(
            ItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }

    }

}