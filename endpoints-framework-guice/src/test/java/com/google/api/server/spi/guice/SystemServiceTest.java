/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.api.server.spi.guice;

import com.google.api.server.spi.BaseSystemServiceTest;
import com.google.api.server.spi.testing.Endpoint0;
import com.google.api.server.spi.testing.TestEndpoint;
import com.google.inject.Guice;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link com.google.api.server.spi.SystemService} with a Guice-enchanced service class.
 * A Guice EnhancedBean will be created if the class contains an interceptor.
 */
@RunWith(JUnit4.class)
public class SystemServiceTest extends BaseSystemServiceTest {
  @Override
  protected TestEndpoint getTestService() {
    return Guice.createInjector(new InterceptorModule()).getInstance(TestEndpoint.class);
  }

  @Override
  protected Endpoint0 getTestService2() {
    return Guice.createInjector(new InterceptorModule()).getInstance(Endpoint0.class);
  }
}
