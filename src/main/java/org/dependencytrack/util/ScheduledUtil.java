/*
 * This file is part of Dependency-Track.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) OWASP Foundation. All Rights Reserved.
 */
package org.dependencytrack.util;

import java.util.Date;

/* 
 * Helper class for scheduled notifications to provide more human-friendly output in the templates.
 * This class is mainly used to provide default values for null objects, which may be common in the Finding objects
 * used in the scheduled notification for new vulnerabilities.
 */
public class ScheduledUtil {
    public static String getValueOrEmptyIfNull(Object value) {
        return value == null ? "" : value.toString();
    }

    public static String getDateOrUnknownIfNull(Date date) {
        return date == null ? "Unknown" : DateUtil.toISO8601(date);
    }
}