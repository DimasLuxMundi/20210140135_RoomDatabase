package com.example.meet10pam.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meet10pam.R
import com.example.meet10pam.model.HomeViewModel
import com.example.meet10pam.model.PenyediaViewModel
import com.example.meet10pam.navigasi.DestinasiNavigasi

object DestinasiHome : DestinasiNavigasi{
    override val route = "home"
    override val titleRes = R.string.app_name
}

@Composable
fun HomeScreen(
    navigateToitemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
){


}
