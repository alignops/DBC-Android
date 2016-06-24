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
	public static com.busybusy.dbc.conditions.ObjectCondition require(*);
	public static com.busybusy.dbc.conditions.DoubleCondition require(java.lang.Double);
    public static com.busybusy.dbc.conditions.FloatCondition require(java.lang.Float);
    public static com.busybusy.dbc.conditions.IntegralCondition require(java.lang.Integer);
    public static com.busybusy.dbc.conditions.IntegralCondition require(java.lang.Long);
    public static com.busybusy.dbc.conditions.ListCondition require(*);
    public static com.busybusy.dbc.conditions.MapCondition require(*);
    public static com.busybusy.dbc.conditions.StringCondition require(java.lang.String);
	public static com.busybusy.dbc.conditions.ObjectCondition check(*);
	public static com.busybusy.dbc.conditions.DoubleCondition check(java.lang.Double);
    public static com.busybusy.dbc.conditions.FloatCondition check(java.lang.Float);
    public static com.busybusy.dbc.conditions.IntegralCondition check(java.lang.Integer);
    public static com.busybusy.dbc.conditions.IntegralCondition check(java.lang.Long);
    public static com.busybusy.dbc.conditions.ListCondition check(*);
    public static com.busybusy.dbc.conditions.MapCondition check(*);
    public static com.busybusy.dbc.conditions.StringCondition check(java.lang.String);
	public static com.busybusy.dbc.conditions.ObjectCondition ensure(*);
	public static com.busybusy.dbc.conditions.DoubleCondition ensure(java.lang.Double);
    public static com.busybusy.dbc.conditions.FloatCondition ensure(java.lang.Float);
    public static com.busybusy.dbc.conditions.IntegralCondition ensure(java.lang.Integer);
    public static com.busybusy.dbc.conditions.IntegralCondition ensure(java.lang.Long);
    public static com.busybusy.dbc.conditions.ListCondition ensure(*);
    public static com.busybusy.dbc.conditions.MapCondition ensure(*);
    public static com.busybusy.dbc.conditions.StringCondition ensure(java.lang.String);
}
