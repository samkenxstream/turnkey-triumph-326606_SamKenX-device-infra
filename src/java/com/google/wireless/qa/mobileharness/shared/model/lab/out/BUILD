# Copyright 2022 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Description:
#   Output data models for Mobile Harness labs and devices.

package(
    default_visibility = ["//src/java/com/google/wireless/qa/mobileharness:__subpackages__"],
)

java_library(
    name = "out",
    srcs = glob(["*.java"]),
    deps = [
        "//src/devtools/mobileharness/api/model/proto:device_java_proto",
        "//src/java/com/google/devtools/deviceinfra/shared/util/logging:google_logger",
        "@maven//:com_google_errorprone_error_prone_annotations",
    ],
)
