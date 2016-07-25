/*
 * Copyright (C) 2016  richie (richie1990@163.com)
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
package com.axle.core;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 全局捕捉异常信息，防止APP崩溃
 * @author richie (richie1990@163.com)
 */
public class CatchExceptionHandler implements UncaughtExceptionHandler{
    private static CatchExceptionHandler instance = new CatchExceptionHandler();
    private ExceptionHandler handler;

    private CatchExceptionHandler(){
    }

    public static CatchExceptionHandler getInstance(){
        return  instance;
    }

    public void init(ExceptionHandler handler){
        this.handler = handler;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex){
        handler.doException(thread, ex);
    }

    public interface ExceptionHandler{
        /**
         * 全局未捕获异常的处理
         * @param thread 异常所在的线程
         * @param ex 抛出的异常
         */
        void doException(Thread thread, Throwable ex);
    }
}
