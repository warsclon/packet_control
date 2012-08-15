/*******************************************************************************
 * Copyright 2012 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
/*
 * Copyright 2012 Diego Martin Moreno (dmartmorsoft@gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
import java.io.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class HttpDatos {

  static boolean OpenHttp() {
    try {


      HttpConnection c = null;
      InputStream is = null;
      OutputStream os = null;
      StringBuffer b = new StringBuffer();
      TextBox t = null;

      c = (HttpConnection) Connector.open(
		  //url with example information
          "http://usuarios.lycos.es:80/flashpoint/datos.txt");
      c.setRequestMethod(HttpConnection.GET);
      c.setRequestProperty("IF-Modified-Since", "20 Jan 2001 16:19:14 GMT");
      c.setRequestProperty("User-Agent",
                           "Profile/MIDP-1.0 Configuration/CLDC-1.0");
      c.setRequestProperty("Content-Language", "es");
      is = c.openDataInputStream();
      int ch;
      Datos datos = new Datos();
      datos.open();
      datos.deleteAll();

      while ( (ch = is.read()) != -1) {
        if (ch == 10) {
          //System.out.println(b);
          datos.recordRegister(b.toString());
          b.delete(0, b.length());
        }        else {
          b.append( (char) ch);
        }

      }

      if (is != null) {
        is.close();
      }
      datos.numberRegisters();
      datos.getList();
      datos.close();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      return false;
    }
    return true;

  }

}
