/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.batch.sample.iosample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.test.AbstractJobTests;
import org.springframework.batch.test.AssertFile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Dan Garrette
 * @since 2.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/simple-job-launcher-context.xml", "/jobs/ioSampleJob.xml",
		"/jobs/iosample/multiResource.xml" })
public class MultiResourceFunctionalTests extends AbstractJobTests {

	/**
	 * Output should be the same as input
	 */
	@Test
	public void testJob() throws Exception {
		this.launchJob();

		AssertFile.assertFileEquals(new FileSystemResource("target/test-outputs/multiResourceOutput.csv.1"),
				new FileSystemResource("src/main/resources/data/iosample/input/delimited.csv"));
		AssertFile.assertFileEquals(new FileSystemResource("target/test-outputs/multiResourceOutput.csv.2"),
				new FileSystemResource("src/main/resources/data/iosample/input/delimited2.csv"));
	}
}