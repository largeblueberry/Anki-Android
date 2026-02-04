/*
 * Copyright (c) 2026 YongWoo Shin <onlym6659@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ichi2.anki

import com.ichi2.anki.SharedDecksActivity.Companion.HTTP_STATUS_TOO_MANY_REQUESTS
import com.ichi2.anki.SharedDecksActivity.Companion.shouldRedirectToLogIn
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SharedDecksActivityTest {
    @Test
    fun shouldRedirectToLogInWhenUserDoesNotLoggedIn() {
        val statusCode = HTTP_STATUS_TOO_MANY_REQUESTS
        val isLoggedIn = false

        val shouldRedirectToLogin = shouldRedirectToLogIn(statusCode, isLoggedIn)

        assertTrue(shouldRedirectToLogin)
    }

    @Test
    fun shouldNotRedirectToLogInWhenUserLoggedIn() {
        val statusCode = HTTP_STATUS_TOO_MANY_REQUESTS
        val isLoggedIn = true

        val shouldRedirectToLogin = shouldRedirectToLogIn(statusCode, isLoggedIn)

        assertFalse(shouldRedirectToLogin)
    }
}
