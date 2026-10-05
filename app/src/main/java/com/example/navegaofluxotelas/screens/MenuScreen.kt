package com.example.navegaofluxotelas.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MenuScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3A4FBA))
            .padding(32.dp)
    ) {
        Text(
            text = "MENU",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = {/* TODO */ },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.size(width = 200.dp, height = 48.dp)
            ) {
                Text(
                    text = "Perfil",
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
            Button(
                onClick = {/* TODO */ },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.size(width = 200.dp, height = 48.dp)
            ) {
                Text(
                    text = "Pedidos",
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
            Button(
                onClick = {/* TODO */ },
                colors = ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier.size(width = 200.dp, height = 48.dp)
            ) {
                Text(
                    text = "Sair",
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
        }
    }
}
