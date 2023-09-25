package com.raveline.compositing.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.raveline.compositing.R
import com.raveline.compositing.ui.screen.ProductFormScreen
import com.raveline.compositing.ui.theme.CompositingTheme
import com.raveline.compositing.ui.viewmodel.ProductFormScreenViewModel


class ProductFormActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositingTheme {
                Surface {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(String())
                                },
                                navigationIcon = {
                                    Icon(
                                        modifier = Modifier
                                            .heightIn(40.dp)
                                            .padding(start = 8.dp, end = 24.dp)
                                            .clickable {
                                                finish()
                                            },
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = stringResource(id = R.string.back)
                                    )
                                }
                            )
                        }
                    ) {
                        Box(modifier = Modifier.padding(it)) {
                            val viewModel by viewModels<ProductFormScreenViewModel>()
                            ProductFormScreen(
                                viewModel = viewModel,
                                onSuccessSaveClick = {
                                    finish()
                                },
                            )
                        }
                    }
                }
            }
        }

    }
}