package ru.horekdev.deltashopapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.horekdev.deltashopapp.ui.theme.*

class MainActivity : ComponentActivity() {
    class DialogState {
        var isOpenHelp by mutableStateOf(false)
        var isOpenBuy by mutableStateOf(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeltaShopAppTheme {
                Column {
                    HeadMenu()
                    BodyMenu()
                }
            }
        }
    }

    @Composable
    private fun HeadMenu() {
        val dialogState = remember {DialogState()}

        Row(modifier = Modifier
            .background(BgColor)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {

            Image(
                modifier = Modifier
                    .padding(start = 5.dp, top = 15.dp)
                    .size(width = 167.dp, height = 133.dp),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo_image")

            Button(onClick = {dialogState.isOpenHelp = true},
                modifier = Modifier
                    .clip(shape = RectangleShape)
                    .padding(end = 20.dp, top = 15.dp)
                    .width(105.dp)
                    .height(37.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(BgBtnHelp)
            ) {

                Text(text = "Помощь",
                    color = Color.Black,
                    fontFamily = FontFamily.Default
                    )

                if (dialogState.isOpenHelp) {
                    HelpBtnLogic(dialogState)
                }
            }
        }
    }

    @Composable
    private fun BodyMenu() {
        val dialogState = remember {DialogState()}

        val fontToMainText = FontFamily(Font(R.font.rubbik_bublles))
        val fontToUnderText = FontFamily(Font(R.font.poppins_bold))

        Column(modifier = Modifier
            .background(BgColor)
            .fillMaxWidth()) {
            Text(text = "Хотели купить \nNITRO?",
                color = Color.White,
                fontFamily = fontToMainText,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(
                    top = 26.dp, bottom = 6.dp,
                    start = 15.dp))

            Text(text = "Открой для себя низкие \n цены и эксклюзивные \n бонусы на Discord Nitro!",
                color = Color.White,
                fontFamily = fontToUnderText,
                fontSize = 18.sp,
                modifier = Modifier.padding(
                    bottom = 6.dp,
                    start = 15.dp))
        }

        Column(
            modifier = Modifier
                .background(BgColor)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = 95.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.main_discord_logo),
                contentDescription = "mainImage",
                modifier = Modifier
                    .padding(top = 15.dp, start = 10.dp, end = 10.dp)
                    .size(width = 320.dp, height = 300.dp)
                    .padding(top = 15.dp, bottom = 20.dp)
            )

                Button(onClick = {dialogState.isOpenBuy = true},
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .width(125.dp)
                        .height(38.dp),
                    colors = ButtonDefaults.buttonColors(BgBtnBuy)
                ) {
                    Text(text = "Купить",
                        color = Color.White,
                        fontFamily = FontFamily.Default)

                    if (dialogState.isOpenBuy) {
                        BuyBtnLogic(dialogState)
                    }
                }
        }
    }

    @Composable
    private fun HelpBtnLogic(dialogState: DialogState) {
        Column(verticalArrangement = Arrangement.Center) {
            AlertDialog(onDismissRequest = {
                dialogState.isOpenHelp = false

            }, confirmButton = {},
                title = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "наша почта: deltanitrowork@gmail.com",
                            color = Color.White,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 60.dp, start = 10.dp))

                        Text(text = "наш дискорд сервер: ЖМИ НА КУПИТЬ",
                            color = Color.White,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(bottom = 30.dp))

                        Button(
                            onClick = { dialogState.isOpenHelp = false},
                            colors = ButtonDefaults.buttonColors(BgDialogBtn)
                        ) {
                            Text(
                                text = "закрыть",
                                color = Color.White,
                                fontFamily = FontFamily.Default
                            )
                        }
                    }
                }, containerColor = BgDialog, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f))
        }
    }

    @Composable
    private fun BuyBtnLogic(dialogState: DialogState) {
        val rules = listOf(
            "1. Покупая и активируя Nitro в Discord, вы соглашаетесь с условиями данного лицензионного соглашения.",
            "2. Владение аккаунтом Nitro предоставляется лично вам и не может быть передано или продано третьим лицам.",
            "3. Discord оставляет за собой право изменять стоимость и содержание Nitro без предварительного уведомления.",
            "4. Вы несете полную ответственность за любое использование аккаунта Nitro, включая обязательство соблюдения условий Discord Community Guidelines.",
            "5. Discord оставляет за собой право отключения или ограничения аккаунта Nitro при нарушении условий использования или обнаружении подозрительной активности.",
            "6. DeltaNitro не несет ответственности за любые убытки, возникшие в результате использования аккаунта Nitro или его компонентов.",
            "7. DeltaNitro оставляет за собой право расторгнуть данное лицензионное соглашение и отключить аккаунт Nitro в случае нарушения политики использования или любых других правил Discord.",
            "8. Все претензии, связанные с аккаунтом Nitro, должны быть направлены в службу поддержки DeltaNitro в соответствии с их правилами и процедурами.",
            "Пожалуйста, обратите внимание, что это простое лицензионное соглашение и его содержание может различаться в зависимости от правил и условий, установленных Discord на момент покупки Nitro."
        )

        Column(verticalArrangement = Arrangement.Center) {
            AlertDialog(onDismissRequest = {dialogState.isOpenBuy = false}, confirmButton = {},
                title = {
                    Column(verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Лицензионное соглашение при покупке Nitro в Discord^",
                            color = Color.White,
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Bold,
                            fontSize = 10.sp,
                            modifier = Modifier.padding(bottom = 10.dp))

                        LazyColumn(modifier = Modifier
                            .fillMaxHeight(0.85f)
                            .padding(15.dp)) {
                            items(rules) {
                                rules -> Text(rules,
                                    color = Color.White,
                                    fontSize = 8.sp)
                            }
                        }

                        Button(onClick = {
                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://discord.gg/YRaRbdDP5B")
                            )
                            this@MainActivity.startActivity(intent)
                            dialogState.isOpenBuy = false

                        }, colors = ButtonDefaults.
                        buttonColors(BgDialogBtn)) {
                            Text(text = "принимаю",
                                color = Color.White)
                        }
                    }
                }, containerColor = BgDialog, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f))
        }
    }
}