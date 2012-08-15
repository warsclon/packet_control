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
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

/**
 * <p>Title: SmsMensajero </p>
 *
 * <p>Description: Clase de arranque del midp</p>
 *
 * <p>Copyright: Copyright (c) 2003</p>
 *
 * <p>Company: WarsClon Company </p>
 * @author Diego Martín Moreno
 * @version 1.0
 */
public class SmsMensajero
    extends MIDlet
    implements CommandListener {

  Display display;

  static SmsMensajero hello;

  private Mensaje mensaje;

  //Clase con la presentación inicial
  private Presentacion presentacion;


  //Clase con el menu de la aplicación
  private MenuInicio menuInit;

  //Clase con el menu de la aplicación
  private Formulario formulario;

  private Config config;

  private Help help;

  //Clase con el menu de la aplicación
  private MenuLista menuList;

  //Clase con el menu de la aplicación
  private About about;

  public SmsMensajero() {
    presentacion = new Presentacion(this);
  }

  protected void destroyApp(boolean b) {
    display.setCurrent(null);
    this.notifyDestroyed(); // notify KVM
  }

  protected void pauseApp() {
  }

  protected void startApp() {
    display = Display.getDisplay(this);
    display.setCurrent(presentacion);
  }

  public void setMenu() {
    menuInit = new MenuInicio(display, this);
  }

  public void config() {
    config = new Config(display,this);
  }

  public void verLista() {
    menuList = new MenuLista(display, this);
  }

  public void initMensaje(String men,int num) {
    mensaje = new Mensaje(this,men,num);
    display.setCurrent(mensaje);
  }

  public void initTable() {

  if (HttpDatos.OpenHttp()) {
    mensaje = new Mensaje(this,"Ok Update");
  } else {
    mensaje = new Mensaje(this,"Error Update");
  }
  display.setCurrent(mensaje);
}
public void borrarTabla() {

try {
    Datos datos = new Datos();
    datos.open();
    datos.deleteAll();
    datos.close();
    datos = null;
    mensaje = new Mensaje(this,"Delete table");
    display.setCurrent(mensaje);

  } catch(Exception ex) {
    mensaje = new Mensaje(this,"Error delete table");
    display.setCurrent(mensaje);

  }
}


public void setAbout() {
  about = new About(this);
  display.setCurrent(about);
}

public void verHelp() {
  help = new Help(this);
  display.setCurrent(help);
}

  public void setFormulario(String calle) {
    formulario = new Formulario(display, this,calle);
  }

  public void commandAction(Command c, Displayable d) {
    String label = c.getLabel();
    if (c.getCommandType() == Command.EXIT) {
      destroyApp(true);
    }
  }

}
