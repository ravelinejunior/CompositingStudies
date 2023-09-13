package com.raveline.compositing.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.raveline.compositing.R
import com.raveline.compositing.model.sampleSections
import com.raveline.compositing.ui.screen.HomeScreen
import com.raveline.compositing.ui.theme.CompositingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(Intent(this, ProductFormActivity::class.java))
            })
        }
    }
}

@Composable
fun App(onFabClick: () -> Unit) {
    // A surface container using the 'background' color from the theme
    CompositingTheme {
        Surface {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(
                        shape = FloatingActionButtonDefaults.extendedFabShape,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(
                            12.dp,
                            12.dp,
                            12.dp,
                            12.dp,
                        ),
                        onClick = onFabClick,
                        containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            tint = Color.LightGray,
                            contentDescription = stringResource(
                                id = R.string.app_name
                            )
                        )
                    }
                }
            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    HomeScreen(sampleSections)
                }
            }
        }
    }
}









