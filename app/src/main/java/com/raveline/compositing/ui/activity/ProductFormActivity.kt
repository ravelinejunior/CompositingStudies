package com.raveline.compositing.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.raveline.compositing.ui.screen.ProductFormScreen
import com.raveline.compositing.ui.theme.CompositingTheme

class ProductFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CompositingTheme {
                Surface {
                    AppForm()
                }
            }
        }

    }
}

@Composable
fun AppForm() {
    ProductFormScreen()
}