/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.absen.backend;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;
import javax.swing.text.Document;
/**
 *
 * @author Lenovo
 */
public class CustomOutputStream 
    extends OutputStream
{
  private JTextArea textArea;
  
  public CustomOutputStream(JTextArea txtArea)
  {
    this.textArea = txtArea;
  }
  
  public void write(int b)
    throws IOException
  {
    this.textArea.append(String.valueOf((char)b));
    
    this.textArea.setCaretPosition(this.textArea.getDocument().getLength());
  }
}
