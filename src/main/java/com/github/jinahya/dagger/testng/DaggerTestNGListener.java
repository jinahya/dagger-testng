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


import dagger.Module;
import dagger.ObjectGraph;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.testng.IConfigurable;
import org.testng.IConfigureCallBack;
import org.testng.IExecutionListener;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;


/**
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
public class DaggerTestNGListener
    implements IExecutionListener, IHookable, IConfigurable {


    private static final Map<Class<?>, Object> TESTS
        = new ConcurrentHashMap<Class<?>, Object>();


    private static final Map<Class<?>, Object> MODULES
        = new ConcurrentHashMap<Class<?>, Object>();


    @Override
    public void onExecutionStart() {

        System.out.println("onExecutionStart()");
    }


    @Override
    public void onExecutionFinish() {

        System.out.println("onExecutionFinish()");

        TESTS.clear();
        MODULES.clear();
    }


    @Override
    public void run(final IHookCallBack callBack,
                    final ITestResult testResult) {

        System.out.println("run(" + callBack + ", " + testResult + ")");

        try {
            injectTestResult(testResult);
        } catch (final ReflectiveOperationException roe) {
            testResult.setThrowable(roe);
            return;
        }

        callBack.runTestMethod(testResult);
    }


    @Override
    public void run(final IConfigureCallBack callBack,
                    final ITestResult testResult) {

        System.out.println("run(" + callBack + ", " + testResult + ")");

        try {
            injectTestResult(testResult);
        } catch (ReflectiveOperationException roe) {
            testResult.setThrowable(roe);
            return;
        }

        callBack.runConfigurationMethod(testResult);
    }


    private void injectTestResult(final ITestResult testResult)
        throws ReflectiveOperationException {

        final Object testInstance = testResult.getInstance();
        if (testInstance == null) {
            return;
        }

        final Class<?> testClass = testInstance.getClass();
        if (TESTS.containsKey(testClass)) {
            return;
        }

        final Dagger dagger = testClass.getAnnotation(Dagger.class);
        if (dagger == null) {
            return;
        }

        final Class<?>[] moduleClasses = dagger.modules();
        final Object[] moduleInstances = new Object[moduleClasses.length];
        for (int i = 0; i < moduleClasses.length; i++) {
            final Class<?> moduleClass = moduleClasses[i];
            if (moduleClass.getAnnotation(Module.class) == null) {
                System.err.println("not annotated with @Module: " + moduleClass);
                continue;
            }
            moduleInstances[i] = MODULES.get(moduleClass);
            if (moduleInstances[i] == null) {
                moduleInstances[i] = moduleClass.newInstance();
                MODULES.put(moduleClass, moduleInstances[i]);
            }
        }

        ObjectGraph.create(moduleInstances).inject(testInstance);
        System.out.println("injected");

        TESTS.put(testClass, testInstance);
    }

}

