package ru.horekdev.deltashopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.horekdev.deltashopapp.ui.theme.BgBtnBuy
import ru.horekdev.deltashopapp.ui.theme.BgBtnHelp
import ru.horekdev.deltashopapp.ui.theme.BgColor
import ru.horekdev.deltashopapp.ui.theme.BgRowLine
import ru.horekdev.deltashopapp.ui.theme.DeltaShopAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeltaShopAppTheme {
                Column {
                    HeadMenu(imageId = R.drawable.logo, btnText = "Помощь")

                    BodyMenu(mainTitle = "Хотели купить \nNITRO?",
                        miniTitle = "Открой для себя низкие \n цены и эксклюзивные \n бонусы на Discord Nitro!",
                        mainImage = R.drawable.main_discord_logo,
                        textBtn = "Купить")

                    RowLineMenu("deltanitro@gmail.com", "all rights reserved 2023")
                }
            }
        }
    }

    @Composable
    private fun HeadMenu(imageId: Int, btnText: String) {
        Row(modifier = Modifier
            .background(BgColor)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {

            Image(
                modifier = Modifier
                    .padding(start = 5.dp, top = 15.dp)
                    .size(width = 167.dp, height = 133.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = imageId),
                contentDescription = "logo_image")

            Button(onClick = {helpBtnLogic()},
                modifier = Modifier
                    .clip(shape = RectangleShape)
                    .padding(end = 20.dp, top = 15.dp)
                    .width(105.dp)
                    .height(37.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(BgBtnHelp)
            ) {

                Text(text = btnText,
                    color = Color.Black,
                    fontFamily = FontFamily.Default
                    )
            }
        }
    }

    @Composable
    private fun BodyMenu(mainTitle: String, miniTitle: String,
                         mainImage: Int, textBtn: String) {
        Column(modifier = Modifier
            .background(BgColor)
            .fillMaxWidth()) {
            Text(text = mainTitle,
                color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(
                    top = 26.dp, bottom = 6.dp,
                    start = 15.dp))

            Text(text = miniTitle,
                color = Color.White,
                fontFamily = FontFamily.Default,
                fontSize = 18.sp,
                modifier = Modifier.padding(
                    bottom = 6.dp,
                    start = 15.dp))
        }

        Column(
            modifier = Modifier
                .background(BgColor)
                .fillMaxWidth()
                .padding(bottom = 95.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = mainImage),
                contentDescription = "mainImage",
                modifier = Modifier
                    .padding(top = 15.dp, start = 10.dp, end = 10.dp)
                    .size(width = 320.dp, height = 300.dp)
                    .padding(top = 15.dp, bottom = 20.dp)
            )

                Button(onClick = {buyBtnLogic()},
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .width(125.dp)
                        .height(38.dp),
                    colors = ButtonDefaults.buttonColors(BgBtnBuy)
                ) {
                    Text(text = textBtn,
                        color = Color.White,
                        fontFamily = FontFamily.Default)
                }
        }
    }

    @Composable
    private fun RowLineMenu(email: String, rights: String) {
        Column(modifier = Modifier
            .background(BgRowLine)
            .fillMaxWidth()
            .padding(bottom = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = email,
                color = Color.White,
                fontFamily = FontFamily.Default,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 6.dp))

            Text(text = rights,
                color = Color.White,
                fontFamily = FontFamily.Default,
                fontSize = 12.sp)
        }
    }

    private fun helpBtnLogic() {}

    private fun buyBtnLogic() {}
}