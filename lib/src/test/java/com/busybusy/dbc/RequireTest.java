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

import java.util.UUID;

import static com.busybusy.dbc.Dbc.requireThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class RequireTest
{
	private static final String INPUT_STRING = "ValidString";
	private static final String INPUT_UUID   = UUID.randomUUID().toString();

	@Test
	public void that_basic() throws Exception
	{
		assertThat(requireThat(INPUT_STRING).isNotNull())
				.isNotNull()
				.isEqualTo(INPUT_STRING);

		assertThatThrownBy(() -> requireThat(null).isNotNull())
				.isInstanceOf(DbcAssertionException.class)
				.hasCauseInstanceOf(NullPointerException.class);
	}

	@Test
	public void that_string() throws Exception
	{
		assertThat(requireThat(INPUT_STRING).isValid()).isEqualTo(INPUT_STRING);
	}

	@Test
	public void that_uuid() throws Exception
	{
		assertThat(requireThat(INPUT_UUID).isValidUUID()).isEqualTo(INPUT_UUID);
	}
}