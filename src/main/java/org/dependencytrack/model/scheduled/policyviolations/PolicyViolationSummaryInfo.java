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
package org.dependencytrack.model.scheduled.policyviolations;

import java.util.Map;

import org.dependencytrack.model.PolicyViolation;

/* 
 * Part of the ScheduledPolicyViolationsIdentified Template Models.
 * Contains detailed information about the amount of the identified policy violations grouped by their type.
 */
public record PolicyViolationSummaryInfo(
        Map<PolicyViolation.Type, Integer> newViolationsByRiskType,
        Map<PolicyViolation.Type, Integer> totalProjectViolationsByRiskType,
        Map<PolicyViolation.Type, Integer> suppressedNewViolationsByRiskType) {
}