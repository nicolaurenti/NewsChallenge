package com.example.newschallenge.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.newschallenge.R
import com.example.newschallenge.ui.AshGray
import com.example.newschallenge.ui.SoftGray
import com.example.newschallenge.ui.TextStyles.contentFontStyle
import com.example.newschallenge.ui.TextStyles.contentLightFontStyle
import com.example.newschallenge.ui.TextStyles.titleFontStyle
import com.example.newschallenge.ui.YaleBlue
import com.example.newschallenge.viewmodel.UserViewModel
import com.example.newschallenge.viewmodel.UserViewModel.UserData

@Composable
fun UserScreen(
    viewModel: UserViewModel = hiltViewModel(),
    onLocationCLick: () -> Unit,
) {
    viewModel.getUserInformation()
    Surface(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)) {
        LazyColumn {
            item { Spacer(modifier = Modifier.height(50.dp)) }
            item {
                ProfileHeader(
                    user = viewModel.userInformation.collectAsState().value,
                    onLocationCLick = onLocationCLick,
                )
            }
            item {
                ProfileContent()
            }
        }
    }
}

@Composable
fun ProfileHeader(user: UserData?, onLocationCLick: () -> Unit) {
    OverlappingBoxes(modifier = Modifier.fillMaxWidth()) {
        AsyncImage(
            model = user?.imageUrl,
            contentDescription = "news image",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
        UserInfoContainer(user, onLocationCLick)
    }
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Spacer(modifier = Modifier.fillMaxWidth().height(20.dp).background(AshGray))
        Card {
            Text(
                text = "About me",
                style = titleFontStyle,
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp),
            )
            Text(
                text = "est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla",
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp),
            )
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(20.dp).background(AshGray))

        Card {
            Text(
                text = "Last seen",
                style = titleFontStyle,
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 16.dp),
            )
            LastNewsSeen()
        }
    }
}

@Composable
fun UserInfoContainer(userData: UserData?, onLocationCLick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(
            topStart = 40.dp,
            topEnd = 40.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp,
        ),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(
                modifier = Modifier
                    .height(50.dp)
                    .padding(vertical = 8.dp),
            )
            Text(text = userData?.name ?: "Unknown name", style = titleFontStyle)
            Text(text = userData?.userName ?: "Unknown user", style = contentFontStyle)
            Row(modifier = Modifier.padding(vertical = 12.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_location_on_24),
                    contentDescription = "location icon",
                )
                Text(text = "User Location", modifier = Modifier.clickable { onLocationCLick() })
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(vertical = 4.dp)) {
                Text(text = "Follow")
            }
            FollowersRow()
        }
    }
}

@Composable
fun LastNewsSeen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        AsyncImage(
            model = "https://picsum.photos/400",
            contentDescription = "news image",
            modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = "qui est esse",
            style = titleFontStyle,
            color = SoftGray,
            modifier = Modifier.padding(16.dp),
        )
    }
}

@Composable
fun FollowersRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        FollowersItem("99", "Following")
        Divider(
            color = YaleBlue,
            modifier = Modifier
                .height(30.dp)
                .width(1.dp),
        )
        FollowersItem("50.5", "Followers")
        Divider(
            color = YaleBlue,
            modifier = Modifier
                .height(30.dp)
                .width(1.dp),
        )
        FollowersItem("2.3M", "Likes")
    }
}

@Composable
fun FollowersItem(amount: String, title: String) {
    Column(
        modifier = Modifier.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = amount, style = titleFontStyle)
        Text(text = title, style = contentLightFontStyle)
    }
}

@Composable
fun OverlappingBoxes(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measure, constraints ->
        val smallBox = measure[0]
        val largeBox = measure[1]
        val looseConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0,
        )
        val largePlaceable = largeBox.measure(looseConstraints)
        val smallPlaceable = smallBox.measure(looseConstraints)
        layout(
            width = constraints.maxWidth,
            height = largePlaceable.height + smallPlaceable.height / 2,
        ) {
            largePlaceable.placeRelative(
                x = 0,
                y = smallPlaceable.height / 2,
            )
            smallPlaceable.placeRelative(
                x = (constraints.maxWidth - smallPlaceable.width) / 2,
                y = 0,

            )
        }
    }
}
