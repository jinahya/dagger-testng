/*
 * Copyright 2015 Jin Kwon &lt;jinahya_at_gmail.com&gt;.
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

package com.github.jinahya.dagger.testng;


import dagger.Lazy;
import javax.inject.Inject;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import static org.testng.FileAssert.fail;
import org.testng.annotations.Test;


/**
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
@Dagger(modules = TimestampModule.class)
public class TimestampTest {


    @Test
    public void test() {

        logger.debug("eager: {}", eager);

        try {
            Thread.sleep(100L);
        } catch (final InterruptedException ie) {
            fail("failed to sleep", ie);
        }

        logger.debug("lazy: {}", lazy.get());
    }


    private transient final Logger logger = getLogger(getClass());


    @Inject
    long eager;


    @Inject
    Lazy<Long> lazy;

}

