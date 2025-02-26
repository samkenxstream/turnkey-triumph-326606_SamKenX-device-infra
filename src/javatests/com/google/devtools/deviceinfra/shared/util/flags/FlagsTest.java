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

package com.google.devtools.deviceinfra.shared.util.flags;

import static com.google.common.truth.Truth.assertThat;

import java.time.Duration;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FlagsTest {

  @After
  public void tearDown() {
    Flags.resetToDefault();
  }

  @Test
  public void parse() throws Exception {
    assertThat(Flags.instance().supplementalResDir.getNonNull()).isEmpty();
    assertThat(Flags.instance().extraAdbCommandTimeout.getNonNull()).isEqualTo(Duration.ZERO);

    Flags.parse(new String[] {"--mh_adb_command_extra_timeout=123s"});

    assertThat(Flags.instance().supplementalResDir.getNonNull()).isEmpty();
    assertThat(Flags.instance().extraAdbCommandTimeout.getNonNull())
        .isEqualTo(Duration.ofSeconds(123L));

    Flags.parse(new String[] {"--supplemental_res_dir=foo"});

    assertThat(Flags.instance().supplementalResDir.getNonNull()).isEqualTo("foo");
    assertThat(Flags.instance().extraAdbCommandTimeout.getNonNull())
        .isEqualTo(Duration.ofSeconds(123L));

    Flags.resetToDefault();

    // deviceinfra:oss-insert-begin(external)
    // assertThat(Flags.instance().supplementalResDir.getNonNull()).isEmpty();
    // assertThat(Flags.instance().extraAdbCommandTimeout.getNonNull()).isEqualTo(Duration.ZERO);
    // deviceinfra:oss-insert-end
  }
}
