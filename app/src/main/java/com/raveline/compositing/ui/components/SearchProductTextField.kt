package com.raveline.compositing.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.raveline.compositing.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchProductTextField(
    inputText: String,
    onSearchChange: (String) -> Unit,
) {

    val focusRequest = remember {
        FocusRequester()
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val view = LocalView.current

    OutlinedTextField(
        value = inputText,
        onValueChange = { value ->
            onSearchChange(value)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
            )
            .focusRequester(focusRequest),
        maxLines = 2,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.app_name)
            )
        },
        trailingIcon = {
            if (inputText.isNotBlank())
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(id = R.string.app_name),
                    Modifier.clickable {
                        onSearchChange(String())
                    }
                )
        },
        label = {
            Text(
                text = stringResource(R.string.search), style = TextStyle(
                    fontFamily = FontFamily.Monospace
                )
            )
        },
        placeholder = {
            Text(
                text = stringResource(R.string.search), style = TextStyle(
                    fontFamily = FontFamily.Monospace
                )
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                keyboardController?.hide()
            }
        ),

        shape = RoundedCornerShape(100)
    )
}