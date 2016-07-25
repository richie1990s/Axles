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
package com.axles;

import com.axle.BaseApplication;
import com.axle.utils.LogUtil;

/**
 *
 * @author richie (richie1990@163.com)
 */
public class AxleApplication extends BaseApplication{

    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    public void doException(Thread thread, Throwable ex){
        LogUtil.e(true, "捕捉全局异常", "", ex);
    }
}
