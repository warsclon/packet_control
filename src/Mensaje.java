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
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Mensaje
    extends Canvas {

  //Objeto midlet
  private MIDlet midlet;
  private String mensaje;
  private String mensaje2;
  private int ver = 0;

  public Mensaje(MIDlet mlet, String men) {
    midlet = mlet;
    mensaje = men;
  }

  public Mensaje(MIDlet mlet, String men, String men2) {
    midlet = mlet;
    mensaje = men;
    mensaje2 = men2;
  }

  public Mensaje(MIDlet mlet, String men,int num) {
    midlet = mlet;
    mensaje = men;
    ver = num;
  }

  public void paint(Graphics g) {

    //color blanco
    g.setColor(255, 255, 255);

    //pinta fondo blanco
    g.fillRect(0, 0, getWidth(), getHeight());

    //color negro
    g.setColor(0, 0, 0);

    g.drawString(
        mensaje,
        4, 10,
        Graphics.LEFT | Graphics.TOP);

   if (mensaje2 != null) {
    g.drawString(
        mensaje2,
        4, 20,
        Graphics.LEFT | Graphics.TOP);
   }


  }

  /**
   * Eventos de teclado
   * @param keyCode Tecla presionada
   */
  protected void keyPressed(int keyCode) {
    if (ver == 0) {
      ( (SmsMensajero) midlet).setMenu();
    } else {
      ( (SmsMensajero) midlet).verLista();
    }
  }

}
