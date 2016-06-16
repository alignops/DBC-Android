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

import com.busybusy.dbc.checks.NumberChecks;

import org.jetbrains.annotations.NonNls;

/**
 * Disabled implementation of number checks
 *
 * @author Trevor
 */
@NonNls
public class NumberCondition_Disabled<T extends Number> extends BasicCondition_Disabled<T> implements NumberChecks<T>
{
	public NumberCondition_Disabled(T subject) { super(subject); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isGreaterThan(T number) {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isGreaterThanOrEqual(T number) {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isLessThan(T number) {}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void isLessThanOrEqual(T number) {}
}
