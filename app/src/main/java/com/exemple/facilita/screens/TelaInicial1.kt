import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.exemple.facilita.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000) // 3 segundos
        navController.navigate("tela_inicio2") {
            popUpTo("splash") { inclusive = true } // remove splash da pilha
        }
    }

    // Layout do splash
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF232323)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logo1),
            contentDescription = "Logo Facilita",
            modifier = Modifier.fillMaxSize()
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    val navController = rememberNavController()
    SplashScreen(navController = navController)
}