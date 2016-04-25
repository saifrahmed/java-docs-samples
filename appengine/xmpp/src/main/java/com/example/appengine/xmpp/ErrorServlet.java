/**
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.xmpp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletInputStream;
import javax.servlet.http.*;
import com.google.common.io.ByteStreams;

// [START example]
@SuppressWarnings("serial")
public class ErrorServlet extends HttpServlet {

   private static final Logger log = Logger.getLogger(ErrorServlet.class.getName());

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
          throws IOException {

        // Parse the POST data, which is sent as a MIME stream containing the stanza.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ServletInputStream inputStream = req.getInputStream();
        ByteStreams.copy(inputStream, baos);

        // Log the error
        log.warning("Error stanza received: " + baos.toString());
    }
}
// [END example]