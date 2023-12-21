package com.example.newschallenge.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.newschallenge.ui.TextStyles
import com.example.newschallenge.viewmodel.UserViewModel.UserData
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun UserLocationScreen() {
    val user = UserData()
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Location",
                style = TextStyles.headerFontStyle,
            )
            AsyncImage(
                model = user.imageUrl,
                contentDescription = "news image",
                modifier = Modifier.size(50.dp).clip(CircleShape),
                contentScale = ContentScale.Crop,
            )
        }

        UserLocation(user.location)
    }
}

@Composable
fun UserLocation(location: Pair<Double, Double>) {
    val recipeLocation = LatLng(location.first, location.second)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(recipeLocation, 10f)
    }

    Card(
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(
            topStart = 40.dp,
            topEnd = 40.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp,
        ),
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
        ) {
            Marker(
                state = MarkerState(position = recipeLocation),
                title = "Singapore",
                snippet = "Marker in Singapore",
            )
        }
    }
}
