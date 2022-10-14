/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.wireless.qa.mobileharness.shared.model.job;

import com.google.common.base.Preconditions;
import java.util.UUID;

/** Locator of a job. */
public class JobLocator {
  private final String id;
  private final String name;

  /**
   * Creates a job locator.
   *
   * @param id job id
   * @param name job name
   */
  public JobLocator(String id, String name) {
    this.id = Preconditions.checkNotNull(id);
    this.name = Preconditions.checkNotNull(name);
  }

  /**
   * Creates a job locator.
   *
   * @param name job name
   */
  public JobLocator(String name) {
    this(UUID.randomUUID().toString(), name);
  }

  public JobLocator(com.google.devtools.mobileharness.api.model.job.JobLocator newJobLocator) {
    this(newJobLocator.id(), newJobLocator.name());
  }

  /** Gets the job id. */
  public String getId() {
    return id;
  }

  /** Gets the job name. */
  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return id;
  }

  public com.google.devtools.mobileharness.api.model.job.JobLocator toNewJobLocator() {
    return com.google.devtools.mobileharness.api.model.job.JobLocator.of(id, name);
  }

  /**
   * Parses a job locator from the string generated by {@link #toString()}.
   *
   * @return the job locator with empty job name, because {@link #toString()} drops the job name
   */
  public static JobLocator parseString(String str) {
    return new JobLocator(str, "");
  }
}