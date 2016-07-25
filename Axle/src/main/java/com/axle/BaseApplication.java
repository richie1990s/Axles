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
package com.axle;

import android.app.Application;

import com.axle.core.CatchExceptionHandler;
import com.axle.core.CatchExceptionHandler.ExceptionHandler;
import com.axle.exception.NoInitException;

/**
 * Application基类，实现全局异常捕捉
 * @author richie (richie1990@163.com)
 */
public abstract class BaseApplication extends Application implements ExceptionHandler{
    private static BaseApplication instance;

    @Override
    public void onCreate(){
        super.onCreate();

        instance = this;
        CatchExceptionHandler.getInstance().init(this);
    }

    public static BaseApplication getInstance(){
        if (instance == null){
            throw new NoInitException("can not find class extend from BaseApplication, have you declared this class in your AndroidManifest.xml ?");
        }
        return instance;
    }
}
