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
package com.omisoft.vitafu.opensubtitlesapi.response;

public class ReplyStatus {

    public static final ReplyStatus OK = new ReplyStatus(200);

    private final int code;
    private final String message;

    public ReplyStatus(int code) {
        this(code, null);
    }

    public ReplyStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReplyStatus that = (ReplyStatus) o;

        return code == that.code;
    }

    @Override
    public String toString() {
        return code + ": \"" + message + "\"";
    }
}
