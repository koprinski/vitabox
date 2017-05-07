/**
 *    Copyright (c) 2015 Wojciech Tekiela
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.omisoft.vitafu.opensubtitlesapi.impl;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.Callable;

class RetriableXmlRpcClient extends XmlRpcClient {

    private final Logger logger = LoggerFactory.getLogger(RetriableXmlRpcClient.class);

    private final int maxAttempts;
    private final long interval;

    public RetriableXmlRpcClient(URL serverUrl) {
        this(serverUrl, 5, 1000);
    }

    public RetriableXmlRpcClient(URL serverUrl, int maxAttempts, long interval) {
        super();

        this.maxAttempts = maxAttempts;
        this.interval = interval;

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(serverUrl);
        setConfig(config);
    }

    @Override
    public Object execute(final String method, final Object[] params) throws XmlRpcException {
        RetryTask execTask = new RetryTask(maxAttempts, interval, method, params);
        try {
            return execTask.call();
        } catch (Exception e) {
            throw new XmlRpcException("Exception occurred during XML-RPC call", e);
        }
    }

    private class RetryTask implements Callable<Object> {

        private Callable<Object> task;
        private int maxAttempts;
        private long interval;

        private RetryTask(int maxAttempts, long interval, final String method, final Object[] params) {
            this.maxAttempts = maxAttempts;
            this.interval = interval;

                this.task = (new Callable<Object>() {

                    @Override
                    public Object call() throws Exception {
                        int attemptsLeft = maxAttempts;
                        while (true) {
                            try {
                                attemptsLeft--;
                                return aaa();
                            } catch (Exception e) {
                                if (attemptsLeft > 0) {
                                    Thread.sleep(interval);
                                } else {
                                    throw e;
                                }
                            }
                        }
                    }

                    public Object aaa() {
                        Object response = null;
                        try {
                        response = RetriableXmlRpcClient.super.execute(method, params);
                        } catch (XmlRpcException e) {
                            e.printStackTrace();
                        }

                        return response;
                    }
                });





        }

        @Override
        public Object call() throws Exception {
            int attemptsLeft = maxAttempts;
            while (true) {
                try {
                    attemptsLeft--;
                    return task.call();
                } catch (Exception e) {
                    if (attemptsLeft > 0) {
                        Thread.sleep(interval);
                    } else {
                        throw e;
                    }
                }
            }
        }
    }
}
