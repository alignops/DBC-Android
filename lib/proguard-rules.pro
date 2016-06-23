# Copyright 2016 Busy, LLC
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.

# This progaurd config should strip out all of the assertions from the processed code
-assumenosideeffects class com.busybusy.Dbc {
	public static <T> ObjectCondition require(T subject);
	public static DoubleCondition require(Double subject);
    public static FloatCondition require(Float subject);
    public static IntegralCondition<Integer> require(Integer subject);
    public static IntegralCondition<Long> require(Long subject);
    public static <T extends List<E>, E> ListCondition<T, E> require(T subject);
    public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> require(T subject);
    public static StringCondition require(String subject);
	public static <T> ObjectCondition check(T subject);
	public static DoubleCondition check(Double subject);
    public static FloatCondition check(Float subject);
    public static IntegralCondition<Integer> check(Integer subject);
    public static IntegralCondition<Long> check(Long subject);
    public static <T extends List<E>, E> ListCondition<T, E> check(T subject);
    public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> check(T subject);
    public static StringCondition check(String subject);
	public static <T> ObjectCondition ensure(T subject);
	public static DoubleCondition ensure(Double subject);
    public static FloatCondition ensure(Float subject);
    public static IntegralCondition<Integer> ensure(Integer subject);
    public static IntegralCondition<Long> ensure(Long subject);
    public static <T extends List<E>, E> ListCondition<T, E> ensure(T subject);
    public static <T extends Map<K, V>, K, V> MapCondition<T, K, V> ensure(T subject);
    public static StringCondition ensure(String subject);
}
