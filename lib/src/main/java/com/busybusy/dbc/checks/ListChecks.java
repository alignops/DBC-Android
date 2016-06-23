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

import java.util.List;

/**
 * Marker interface for CollectionChecks targeting {@linkplain List} types
 *
 * @author Trevor
 */
public interface ListChecks<T extends List<E>, E, Self extends ListChecks<T, E, Self>> extends CollectionChecks<T, Self>
{
}
