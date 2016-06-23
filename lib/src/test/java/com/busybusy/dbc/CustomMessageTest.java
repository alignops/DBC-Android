/*
 * Copyright 2016 Busy, LLC
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.busybusy.dbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.busybusy.dbc.Dbc.require;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class CustomMessageTest
{
	@Test
	public void testCustomMessage() throws Exception
	{
		assertThatThrownBy(() -> require(2D).message("CustomMessage").isNearZero()).hasMessageContaining("CustomMessage");
	}

	@Test
	public void testCustomMessage_Lazy() throws Exception
	{
		assertThatThrownBy(() -> require(2D).message(() -> "CustomMessage" + "LazyMessage").isNearZero()).hasMessageContaining("CustomMessageLazyMessage");
	}

	@Test
	public void testCustomMessage_Lazy_ThrewException() throws Exception
	{
		assertThatThrownBy(() -> require(2D).message(() -> {
			throw new RuntimeException("ThrowBeforeTheLibraryCan");
		}).isNearZero()).hasMessageContaining("ThrowBeforeTheLibraryCan");
	}
}
