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
package org.dependencytrack.notification.vo;

import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dependencytrack.model.PolicyViolation;
import org.dependencytrack.model.Project;
import org.dependencytrack.model.scheduled.policyviolations.PolicyViolationDetails;
import org.dependencytrack.model.scheduled.policyviolations.PolicyViolationOverview;
import org.dependencytrack.model.scheduled.policyviolations.PolicyViolationSummary;
import org.dependencytrack.persistence.QueryManager;

public class ScheduledPolicyViolationsIdentified {
    private final PolicyViolationOverview overview;
    private final PolicyViolationSummary summary;
    private final PolicyViolationDetails details;

    public ScheduledPolicyViolationsIdentified(final List<Project> affectedProjects, ZonedDateTime lastExecution) {
        try (var qm = new QueryManager()){
            Map<Project, List<PolicyViolation>> affectedProjectViolations = new LinkedHashMap<>();
            for (Project project : affectedProjects) {
                var violations = qm.getPolicyViolationsSince(project, true, lastExecution).getList(PolicyViolation.class);
                affectedProjectViolations.put(project, violations);
            }
            this.overview = new PolicyViolationOverview(affectedProjectViolations);
            this.summary = new PolicyViolationSummary(affectedProjectViolations);
            this.details = new PolicyViolationDetails(affectedProjectViolations);
        }
    }

    public PolicyViolationOverview getOverview() {
        return overview;
    }

    public PolicyViolationSummary getSummary() {
        return summary;
    }

    public PolicyViolationDetails getDetails() {
        return details;
    }
}
