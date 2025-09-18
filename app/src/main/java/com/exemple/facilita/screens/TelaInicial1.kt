
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TelaProfile(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    )
    {
        Image(
            painter = painterResource(com.exemple.facilita.R.drawable.logo1),
            contentDescription = "Logo tela inicial",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun TelaProfilePreview() {
    TelaProfile()
}