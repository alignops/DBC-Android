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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Trevor
 */
@RunWith(JUnit4.class)
public class MapConditionTest
{
	Map<String, String> input;

	@Before
	public void setUp() throws Exception
	{
		this.input = new LinkedHashMap<>();
		this.input.put("KeyOne", "ValOne");
		this.input.put("KeyTwo", "ValTwo");
		this.input.put("KeyThree", "ValThree");
	}

	@Test
	public void isNotEmpty_enabled() throws Exception
	{
		MapCondition<Map<String, String>, String, String> condition = new MapCondition<>(this.input, true);
		condition.isNotEmpty();

		MapCondition<Map<String, String>, String, String> badCondition = new MapCondition<>(new LinkedHashMap<>(), true);
		Assertions.assertThatThrownBy(badCondition::isNotEmpty)
		          .isInstanceOf(DbcAssertionException.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void isNotEmpty_disabled() throws Exception
	{
		MapCondition<Map<String, String>, String, String> condition = new MapCondition<>(this.input, false);
		condition.isNotEmpty();

		MapCondition<Map<String, String>, String, String> badCondition = new MapCondition<>(new LinkedHashMap<>(), false);
		badCondition.isNotEmpty();
	}

	@Test
	public void hasSize_enabled() throws Exception
	{
		MapCondition<Map<String, String>, String, String> condition = new MapCondition<>(this.input, true);
		condition.hasSize(3);

		Assertions.assertThatThrownBy(() -> condition.hasSize(2))
		          .isInstanceOf(DbcAssertionException.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void hasSize_disabled() throws Exception
	{
		MapCondition<Map<String, String>, String, String> condition = new MapCondition<>(this.input, false);
		condition.hasSize(3).hasSize(2);
	}

	@Test
	public void hasSizeBetween_enabled() throws Exception
	{
		MapCondition<Map<String, String>, String, String> condition = new MapCondition<>(this.input, true);
		condition.hasSizeBetween(3, 5);

		Assertions.assertThatThrownBy(() -> condition.hasSizeBetween(25, 624))
		          .isInstanceOf(DbcAssertionException.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void hasSizeBetween_disabled() throws Exception
	{
		MapCondition<Map<String, String>, String, String> condition = new MapCondition<>(this.input, false);
		condition.hasSizeBetween(3, 5).hasSizeBetween(25, 624);
	}

	@Test
	public void containsKey_enabled() throws Exception
	{
		MapCondition<Map<String, String>, String, String> condition = new MapCondition<>(this.input, true);
		condition.containsKey("KeyTwo");

		Assertions.assertThatThrownBy(() -> condition.containsKey("Chicago"))
		          .isInstanceOf(DbcAssertionException.class)
		          .hasCauseInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void containsKey_disabled() throws Exception
	{
		MapCondition<Map<String, String>, String, String> condition = new MapCondition<>(this.input, false);
		condition.containsKey("KeyTwo").containsKey("Chicago");
	}

}