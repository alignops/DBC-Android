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
-assumenosideeffects class com.busybusy.dbc.Dbc {
	public static ObjectCondition require(T);
	public static DoubleCondition require(Double);
    public static FloatCondition require(Float);
    public static IntegralCondition require(Integer);
    public static IntegralCondition require(Long);
    public static ListCondition require(T);
    public static MapCondition require(T);
    public static StringCondition require(String);
	public static ObjectCondition check(T);
	public static DoubleCondition check(Double);
    public static FloatCondition check(Float);
    public static IntegralCondition check(Integer);
    public static IntegralCondition check(Long);
    public static ListCondition check(T);
    public static MapCondition check(T);
    public static StringCondition check(String);
	public static ObjectCondition ensure(T);
	public static DoubleCondition ensure(Double);
    public static FloatCondition ensure(Float);
    public static IntegralCondition ensure(Integer);
    public static IntegralCondition ensure(Long);
    public static ListCondition ensure(T);
    public static MapCondition ensure(T);
    public static StringCondition ensure(String);
}
