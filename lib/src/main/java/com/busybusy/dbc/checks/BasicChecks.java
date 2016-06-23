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

package com.busybusy.dbc.checks;

import java.util.Comparator;

/**
 * Combined marker type
 *
 * @author Trevor
 */
public interface BasicChecks<T, Self extends BasicChecks<T, Self>> extends NullChecks<BasicChecks<T, Self>>, BlockChecks<T, Self>
{
	/**
	 * Assert that the subject object is equal to param with .equals(T)
	 *
	 * @param toCompare Object to compare against subject
	 */
	Self isEqualTo(T toCompare);


	/**
	 * Assert that the subject object is equal to param with custom comparator
	 *
	 * @param toCompare        Object to compare against subject
	 * @param customComparator Comparator to use against subject and toCompare object
	 */
	Self isEqualTo(T toCompare, Comparator<T> customComparator);
}
