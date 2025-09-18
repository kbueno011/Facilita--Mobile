package com.exemple.facilita.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.exemple.facilita.R

@Composable
fun TelaLogin(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF444444))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // --- Logo e imagens ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .background(Color(0xFF444444)),
            ) {
                Image(
                    painter = painterResource(R.drawable.logotcc),
                    contentDescription = "Logo Facilita",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .height(100.dp)
                        .width(130.dp)
                        .padding( start = 30.dp)
                )
                Image(
                    painter = painterResource(R.drawable.texturalateral),
                    contentDescription = "Textura lateral",
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .height(200.dp)
                        .width(200.dp)
                )
                Image(
                    painter = painterResource(R.drawable.icongeladeiralogin),
                    contentDescription = "Icone da geladeira",
                    modifier = Modifier
                        .height(350.dp)
                        .width(300.dp)
                        .padding(top = 120.dp, start = 30.dp)
                )
            }

            // --- Card branco ---
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Fazer login",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Tabs
                    var selectedTab by remember { mutableStateOf(0) }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        TabButton("Email", selectedTab == 0) { selectedTab = 0 }
                        Spacer(modifier = Modifier.width(8.dp))
                        TabButton("Celular", selectedTab == 1) { selectedTab = 1 }
                    }

                    // --- Estados para os campos ---
                    var email by remember { mutableStateOf("") }
                    var senha by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        placeholder = { Text("seuemail@gmail.com") },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Email, contentDescription = null)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = senha,
                        onValueChange = { senha = it },
                        label = { Text("Senha") },
                        visualTransformation = PasswordVisualTransformation(),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                        },
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.iconver),
                                contentDescription = "Mostrar senha",
                                modifier = Modifier.height(20.dp).width(20.dp)
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = "Esqueceu sua senha?",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(top = 8.dp, bottom = 8.dp)
                    )

                    // --- Botão Entrar ---
                    Button(
                        onClick = {
                            // aqui você chama a API depois
                            navController.navigate("tela_tipo_conta")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        contentPadding = PaddingValues()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = Brush.horizontalGradient(
                                        listOf(Color(0xFF019D31), Color(0xFF06C755))
                                    ),
                                    shape = RoundedCornerShape(50)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Entrar",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // --- Cadastro ---
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Não possui uma conta?", fontSize = 14.sp, color = Color.Black)
                        Text(
                            text = "Cadastre-se aqui",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF019D31),
                            modifier = Modifier.clickable {
                                navController.navigate("tela_cadastro")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TabButton(text: String, selected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.height(40.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color(0xFF019D31) else Color.Gray,
            contentColor = Color.White
        )
    ) {
        Text(text)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaLoginPreview() {
    val navController = rememberNavController()
    TelaLogin(navController = navController)
}
