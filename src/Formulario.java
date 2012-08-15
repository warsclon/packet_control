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

/**
 * <p>Title: Menu</p>
 * <p>Description: Menu de a la aplicación</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: WarsClon Company </p>
 * @author Diego Martín Moreno
 * @version 1.0
 */
public class Formulario
    extends Form
    implements ItemStateListener, CommandListener {

  //Lista del menu
  private Form form = new Form("Entrega:");

  //Midlet para llamar a los mapas
  private MIDlet midlet;

  //pantalla donde se muestra el menu
  private Display display;

  Datos datos;

  int numReg;

  //Comando salir de la aplicación
  private static final Command salir = new Command("exit", Command.EXIT, 1);

  //Comando salir de la aplicación
  //private static final Command ok = new Command("ok", Command.OK,2);

  TextField textField;
  StringItem stringItem;
  StringItem stringItem2;
  ChoiceGroup choiceGroup;
  String codigo;

  /**
   * Constructor del menu
   * @param d Display para mostrar el menu
   * @param m Midlet para llamar a otras clases
   */
  public Formulario(Display d, MIDlet m, String info) {
    super("Principal");
    display = d;
    midlet = m;
    //Recogida
    if (Parser.getType(info).equals("R")) {
      form.setTitle("Collection:");
      //Envio
    }
    else {
      form.setTitle("Delivery:");
    }
    stringItem = new StringItem("User:", Parser.getName(info));
    form.append(stringItem);
    stringItem2 = new StringItem("Address:", Parser.getStreet(info));
    form.append(stringItem2);
    textField = new TextField("Code package:", "", 5,
                              javax.microedition.lcdui.TextField.NUMERIC);
    form.append(textField);
    codigo = Parser.getNumberCheck(info);
    numReg = Parser.getRegister(info);
    //String textOptions[] = {"Bueno","Regular","Malo"};
    //choiceGroup = new ChoiceGroup("Valoracion:",javax.microedition.lcdui.ChoiceGroup.EXCLUSIVE,textOptions,null);
    //form.append(choiceGroup);
    form.addCommand(salir);
    //form.addCommand(ok);
    form.setCommandListener(this);
    form.setItemStateListener(this);
    d.setCurrent(form);
  }

  /**
   * Captura evento del teclado del menu
   * @param c Teclado
   * @param d Pantalla
   */
  public void commandAction(Command c, Displayable d) {

    if (c.getCommandType() == salir.getCommandType()) {
      if (textField.getString().length() == 0) {
        ( (SmsMensajero) midlet).verLista();
      }
      else {
        if (textField.getString().equals(codigo)) {
          try {
            datos = new Datos();
            datos.open();
            datos.delete(numReg);
            datos.close();
            ( (SmsMensajero) midlet).initMensaje("Code Ok", 1);
          }
          catch (Exception ex) {
            ( (SmsMensajero) midlet).initMensaje("Error update", 1);
            ex.printStackTrace();
          }

        }
        else {
          ( (SmsMensajero) midlet).initMensaje("Code Error", 1);
        }
      }
    }
    //guardarDatos();
  }

  public void itemStateChanged(Item i) {
    //System.out.println("acciones item");
  }

}
