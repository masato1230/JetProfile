package com.jp_funda.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jp_funda.profile.components.DetailSection
import com.jp_funda.profile.components.CompanySection
import com.jp_funda.profile.ui.theme.ProfileTheme
import com.jp_funda.profile.ui.theme.Red

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        // プロフィール画像
        Image(
            painter = painterResource(R.drawable.img_profile),
            contentDescription = "profile",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(10.dp)),
        )
        Spacer(modifier = Modifier.height(20.dp))

        // 名前
        Text(
            text = "山田 太郎",
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold,
        )
        Spacer(modifier = Modifier.height(20.dp))

        // 職業
        Text(text = "職業: Androidエンジニア", color = Color.Gray, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(20.dp))

        // 会社情報
        CompanySection()
        Spacer(modifier = Modifier.height(20.dp))

        // 詳細表示ボタン
        var isShowDetail by remember { mutableStateOf(false) }

        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Red),
            onClick = { isShowDetail = !isShowDetail },
        ) {
            val buttonTitle = if (isShowDetail) "詳細を非表示にする" else "詳細を表示"
            Text(text = buttonTitle, color = Color.White)
        }
        Spacer(modifier = Modifier.height(20.dp))

        // 趣味 & 居住地
        if (isShowDetail) {
            DetailSection()
        }
    }
}