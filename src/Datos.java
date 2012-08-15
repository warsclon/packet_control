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
import java.util.Vector;

/*
Example datos load from url
1#Telephone Com#2865 E Coast Hwy Ste 308#R#12345#0
2# Leap Systems#Palo Alto, CA 94301#R#12345#0
3#1-On-1 Technologies Inc#Alexandria, VA 22301#E#12345#0
4#Site Design#Dayton, OH 45439-0084#E#12345#0
5#Source Computer Solutions#11282 Woodhill Dr#E#12345#0
6#Interactive#810 Regal Dr SW Ste B#R#12345#0
7#N 2N Systems Inc#5300 W Sahara Ave Ste 101#R#12345#0
8#Valve Software#BELLEVUE WA 98009#E#12345#0
*/

public class Datos {

  private RecordStore recordStore;
  private ByteArrayOutputStream byOut;
  private ByteArrayInputStream byInput;
  private DataOutputStream daOut;
  private DataInputStream daInput;
  private RecordEnumeration lista;
  private String contenido;
  int cont;

  public Datos() {
    byOut = new ByteArrayOutputStream();
  }

  public void open() throws Exception {
    recordStore = RecordStore.openRecordStore("userDB", true);
    lista = recordStore.enumerateRecords(null,null,false);
    //System.out.println("Abre base de datos");
  }

  public void close() throws Exception {
    recordStore.closeRecordStore();
    //System.out.println("Cierra base de datos");
  }

  public void recordRegister(String valor) throws Exception {
    valor = valor.substring(0,valor.length()-1);
    valor = valor+"#"+recordStore.getNextRecordID();
    byOut = new ByteArrayOutputStream();
    daOut = new DataOutputStream(byOut);
    daOut.writeUTF(valor);
    byte[] vecDAtos = byOut.toByteArray();
    recordStore.addRecord(vecDAtos, 0, vecDAtos.length);
  }



   public void numberRegisters() throws Exception {
    //System.out.println("Número de registros:" + recordStore.getNumRecords());
  }

  public void getList() throws Exception {

   lista = recordStore.enumerateRecords(null,null,false);
    while(lista.hasNextElement()) {
      byInput = new ByteArrayInputStream(lista.nextRecord());
      daInput = new DataInputStream(byInput);
    }

  }

  public void delete(int num) throws Exception {
    recordStore.deleteRecord(num);
  }


  public List getListMenu (Vector list)  throws Exception {
    List l =  new List("2.List package", List.IMPLICIT);
    lista = recordStore.enumerateRecords(null,null,false);

     while(lista.hasNextElement()) {


       byInput = new ByteArrayInputStream(lista.nextRecord());
       daInput = new DataInputStream(byInput);
       String  cadena = daInput.readUTF();
       list.addElement(cadena);
       //System.out.println("pre>>"+lista.previousRecordId());
       //cadena = cadena.substring(cadena.indexOf(35)+1,cadena.lastIndexOf(35));
       l.append(Parser.getStreet(cadena),null);
     }

    return l;
  }

  public void getListString() throws Exception {

   lista = recordStore.enumerateRecords(null,null,false);
    while(lista.hasNextElement()) {
      byInput = new ByteArrayInputStream(lista.nextRecord());
      daInput = new DataInputStream(byInput);
    }

  }

  public void deleteAll() throws Exception {
    while(lista.hasNextElement()) {
      recordStore.deleteRecord(lista.nextRecordId());
    }
  }

}
