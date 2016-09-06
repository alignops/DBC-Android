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

/**
 * Checks that can be expressed on lists or maps
 *
 * @author Trevor
 * @see ListChecks
 * @see MapChecks
 */
public interface CollectionChecks<T, Self extends CollectionChecks<T, Self>> extends BasicChecks<T, Self>
{
	/**
	 * Assert that the subject list or map is not empty
	 */
	Self isNotEmpty();

	/**
	 * Assert that the subject list or map has specific size
	 *
	 * @param size
	 */
	Self hasSize(int size);

	/**
	 * Assert that the subject list or map has size within range
	 *
	 * @param startInclusive minimum size
	 * @param endInclusive   maximum size
	 */
	Self hasSizeBetween(int startInclusive, int endInclusive);

	/**
	 * Assert that the subject collection has size greater than specific value
	 *
	 * @param minSizeExclusive minimum exclusive size
	 */
	Self hasSizeGreaterThan(int minSizeExclusive);

	/**
	 * Assert that the subject collection has size greater or equal than specific value
	 *
	 * @param minSize minimum size
	 */
	Self hasSizeGreaterThanOrEqual(int minSize);

	/**
	 * Assert that the subject collection has size less than specific value
	 *
	 * @param maxSizeExclusive maximum exclusive size
	 */
	Self hasSizeLessThan(int maxSizeExclusive);

	/**
	 * Assert that the subject collection has size less or equal than specific value
	 *
	 * @param maxSize maximum size
	 */
	Self hasSizeLessThanOrEqual(int maxSize);
}
