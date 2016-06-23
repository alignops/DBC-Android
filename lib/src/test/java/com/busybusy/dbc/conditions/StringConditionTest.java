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

package com.busybusy.dbc.conditions;

import com.busybusy.dbc.DbcAssertionException;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class StringConditionTest
{
	@Test
	public void isValid_enabled() throws Exception
	{
		StringCondition condition = new StringCondition("Input", true);
		condition.isValid();

		StringCondition badCondition = new StringCondition("", true);
		Assertions.assertThatThrownBy(badCondition::isValid)
		          .isInstanceOf(DbcAssertionException.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isValid_disabled() throws Exception
	{
		StringCondition condition = new StringCondition("Input", false);
		condition.isValid();

		StringCondition badCondition = new StringCondition("", false);
		badCondition.isValid();
	}

	@Test
	public void isValidUUID_enabled() throws Exception
	{
		StringCondition condition = new StringCondition(UUID.randomUUID().toString(), true);
		condition.isValidUUID();

		StringCondition badCondition = new StringCondition("", true);
		Assertions.assertThatThrownBy(badCondition::isValidUUID)
		          .isInstanceOf(DbcAssertionException.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isValidUUID_disabled() throws Exception
	{
		StringCondition condition = new StringCondition(UUID.randomUUID().toString(), false);
		condition.isValidUUID();

		StringCondition badCondition = new StringCondition("", false);
		badCondition.isValidUUID();
	}
}