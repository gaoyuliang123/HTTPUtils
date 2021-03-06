package de.taimos.httputils.callbacks;

/*
 * #%L
 * Taimos HTTPUtils
 * %%
 * Copyright (C) 2012 - 2015 Taimos GmbH
 * %%
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
 * #L%
 */

import org.apache.http.HttpResponse;

import de.taimos.httputils.HTTPResponse;
import de.taimos.httputils.HTTPResponseCallback;

public abstract class HTTPStatusCheckCallback implements HTTPResponseCallback {

    @Override
    public final void response(final HTTPResponse response) {
        int statusCode = response.getStatus();
        if (statusCode != this.expectedStatus()) {
            this.invalidStatus(statusCode, response);
        }
        this.checkedResponse(response);
    }

    protected abstract void checkedResponse(HTTPResponse response);

    protected abstract void invalidStatus(int status, HTTPResponse response);

    /**
     * @return the expected status code of the {@link HttpResponse}
     */
    protected int expectedStatus() {
        return 200;
    }

}
