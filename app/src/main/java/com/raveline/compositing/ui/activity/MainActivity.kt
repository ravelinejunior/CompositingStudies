package com.raveline.compositing.ui.activity

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.raveline.compositing.dao.ProductsDao
import com.raveline.compositing.model.sampleCandies
import com.raveline.compositing.model.sampleDrinks
import com.raveline.compositing.model.sampleWomen
import com.raveline.compositing.ui.screen.HomeScreen
import com.raveline.compositing.ui.theme.CompositingTheme

class MainActivity : ComponentActivity() {

    private val dao = ProductsDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                onFabClick =
                {
                    startActivity(Intent(this, ProductFormActivity::class.java))
                },

                content = {
                    val sections = mapOf(
                        "All Products" to dao.productsList(),
                        "Sales" to sampleDrinks + sampleCandies,
                        "Candies" to sampleCandies,
                        "Drinks" to sampleDrinks,
                        "Women" to sampleWomen,
                    )
                    HomeScreen(sections = sections)
                }
            )
        }
    }
}

@Composable
fun App(
    onFabClick: () -> Unit,
    content: @Composable () -> Unit = {},
) {
    // A surface container using the 'background' color from the theme
    CompositingTheme {
        Surface {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(
                            12.dp,
                            12.dp,
                            12.dp,
                            12.dp,
                        ),
                        onClick = onFabClick,
                        shape = RoundedCornerShape(25),
                        containerColor = MaterialTheme.colorScheme.primary
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Add,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            contentDescription = stringResource(
                                id = R.string.app_name
                            )
                        )
                    }
                }
            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}









