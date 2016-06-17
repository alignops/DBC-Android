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
public class MapCondition_DisabledTest
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
	public void isNotEmpty() throws Exception
	{
		MapCondition_Disabled<Map<String, String>, String, String> condition = new MapCondition_Disabled<>(this.input);
		condition.isNotEmpty();

		MapCondition_Disabled<Map<String, String>, String, String> badCondition = new MapCondition_Disabled<>(new LinkedHashMap<>());
		badCondition.isNotEmpty();
	}

	@Test
	public void hasSize() throws Exception
	{
		MapCondition_Disabled<Map<String, String>, String, String> condition = new MapCondition_Disabled<>(this.input);
		condition.hasSize(3);
		condition.hasSize(2);
	}

	@Test
	public void hasSizeBetween() throws Exception
	{
		MapCondition_Disabled<Map<String, String>, String, String> condition = new MapCondition_Disabled<>(this.input);
		condition.hasSizeBetween(3, 5);
		condition.hasSizeBetween(25, 624);
	}

	@Test
	public void containsKey() throws Exception
	{
		MapCondition_Disabled<Map<String, String>, String, String> condition = new MapCondition_Disabled<>(this.input);
		condition.containsKey("KeyTwo");
		condition.containsKey("Chicago");
	}
}