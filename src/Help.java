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

public class Help
    extends Canvas {

  //Objeto midlet
  private MIDlet midlet;

  public Help(MIDlet mlet) {
    midlet = mlet;
  }

  public void paint(Graphics g) {

    //color negro
    g.setColor(0, 0, 0);
    g.fillRect(0, 0, getWidth(), getHeight());

    g.setColor(255, 255, 255);
    g.setFont(Font.getFont(Font.FACE_PROPORTIONAL,Font.STYLE_PLAIN,Font.SIZE_SMALL));

    g.drawString(
        "Application for ",
        4, 10,
        Graphics.LEFT | Graphics.TOP);
    g.drawString(
        "control of ",
        4, 20,
        Graphics.LEFT | Graphics.TOP);
    g.drawString(
        "packages.",
        4, 30,
        Graphics.LEFT | Graphics.TOP);

  }

  /**
   * Eventos de teclado
   * @param keyCode Tecla presionada
   */
  protected void keyPressed(int keyCode) {
    ( (SmsMensajero) midlet).setMenu();
  }

}
