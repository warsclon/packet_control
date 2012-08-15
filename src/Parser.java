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
import javax.microedition.rms.*;
import java.io.*;
import javax.microedition.lcdui.List;
import javax.microedition.*;

public class Parser {

  public static String getId (String temp ) {
    return temp;
  }
  public static int getRegister (String temp ) {
    String salida = temp.substring(temp.lastIndexOf(35)+1);

    //System.out.println("num_reg:"+salida);
    return Integer.parseInt(salida);
  }

  public static String getName (String temp ) {
    String salida = temp.substring(temp.indexOf(35)+1);
    salida = salida.substring(0,salida.indexOf(35));
    return salida;
  }

  public static String getStreet (String temp ) {
    String salida = temp.substring(temp.indexOf(35)+1);
    salida = salida.substring(salida.indexOf(35)+1);
    salida = salida.substring(0,salida.indexOf(35));
    return salida;
  }

  public static String getType (String temp ) {
    String salida = temp.substring(temp.indexOf(35)+1);
    salida = salida.substring(salida.indexOf(35)+1);
    salida = salida.substring(salida.indexOf(35)+1);
    salida = salida.substring(0,salida.indexOf(35));
    return salida;
  }

  public static String getNumberCheck (String temp ) {
    String salida = temp.substring(temp.indexOf(35)+1);
    salida = salida.substring(salida.indexOf(35)+1);
    salida = salida.substring(salida.indexOf(35)+1);
    salida = salida.substring(salida.indexOf(35)+1);
    salida = salida.substring(0,5);
    return salida;
  }

}
