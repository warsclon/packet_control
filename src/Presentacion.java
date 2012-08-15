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

/**
 *
 * <p>Title: Presentacion </p>
 * <p>Description: Clase runnable que muestra el logo de batmap y espara a tener las 5 imagenes cargadas</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: WarsClon Company </p>
 * @author Diego Martín Moreno
 * @version 1.0
 */
public class Presentacion
    extends Canvas {

  //Objeto midlet
  private MIDlet midlet;

  //Imagen de la presentación
  private Image fondo;

  /**
   * Constructor de la presentación y se le pasa
   * el objeto midlet
   * @param mlet Objeto MIDlet
   */
  public Presentacion(MIDlet mlet) {

    midlet = mlet;

    try {

      //Logo del inicio
      fondo = Image.createImage("/sms.png");

    }
    catch (Exception ex) {
     // System.out.println("error presentacion:" + ex);
    }

  }


  /**
   * Pinta la pantalla de la presentación
   * @param g Objeto graphics
   */
  public void paint(Graphics g) {


    //color negro
    g.setColor(0, 0, 0);

    //pinta fondo blanco
    g.fillRect(0, 0, getWidth(), getHeight());


    //Pinta logo
    g.drawImage(fondo,
                (getWidth() / 2) - 45,
			(getHeight() / 2) - 25,
                //0,
                //0,
                Graphics.LEFT | Graphics.TOP);


    /*g.drawString(
        "Messengers Control",
        4, 10,
        Graphics.LEFT | Graphics.TOP);*/


  }

  /**
   * Eventos de teclado
   * @param keyCode Tecla presionada
   */
  protected void keyPressed(int keyCode) {
    ( (SmsMensajero) midlet).setMenu();
  }

}
