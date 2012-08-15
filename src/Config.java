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
import java.util.Vector;

/**
 * <p>Title: Menu</p>
 * <p>Description: Menu de a la aplicaci�n</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: WarsClon Company </p>
 * @author Diego Mart�n Moreno
 * @version 1.0
 */
public class Config
    extends Form
    implements CommandListener {

  //opciones del menu
  private String opciones[] = {
      "Update", "Delete DDBB"};

  Datos datos;
  //Lista del menu
  private List mOpciones = new List("2.Config", Choice.IMPLICIT,
                                    opciones, null);

  private Vector list;

  //Midlet para llamar a los mapas
  private MIDlet midlet;

  //pantalla donde se muestra el menu
  private Display display;

  //Comando salir de la aplicaci�n
  private static final Command salir = new Command("exit", Command.EXIT, 1);

  //Comando salir de la aplicaci�n
  private static final Command ok = new Command("ok", Command.OK, 2);

  /**
   * Constructor del menu
   * @param d Display para mostrar el menu
   * @param m Midlet para llamar a otras clases
   */
  public Config(Display d, MIDlet m) {
    super("Lista");
    display = d;
    midlet = m;
    mOpciones.addCommand(salir);
    mOpciones.setCommandListener(this);
    d.setCurrent(mOpciones);

  }

  /**
   * Captura evento del teclado del menu
   * @param c Teclado
   * @param d Pantalla
   */
  public void commandAction(Command c, Displayable d) {
    if (c.getCommandType() == salir.getCommandType()) {
      ( (SmsMensajero) midlet).setMenu();
    }
    else {
      if (c == List.SELECT_COMMAND) {
        switch (mOpciones.getSelectedIndex()) {
          case 0:
            ( (SmsMensajero) midlet).initTable();
            break;
          case 1:
            ( (SmsMensajero) midlet).borrarTabla();
            break;
        }
      }

    }

  }
}
