/*
 * Copyright 2023 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.resources.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.ColorResource
import dev.icerock.moko.resources.getNSColor
import platform.AppKit.NSColor

@Composable
actual fun colorResource(resource: ColorResource): Color {
    // read darkmode to call recomposition when system settings will be changed
    val darkMode: Boolean = isSystemInDarkTheme()
    val ciColor: NSColor = resource.getNSColor()
    return Color(
        red = ciColor.redComponent.toFloat(),
        green = ciColor.greenComponent.toFloat(),
        blue = ciColor.blueComponent.toFloat(),
        alpha = ciColor.alphaComponent.toFloat()
    )
}
