package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



/**
 * Practica1.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Practica1 extends JFrame{
static GL gl;
    static GLU glu;
    
    public Practica1 (){
        setTitle("Mapa de Bits");
        setSize(500, 500);
        //Instanciamos la clase Graphic
       // GraphicListener listener = new GraphicListener();
        //Creamos el canvas
       // GLCanvas canvas = new GLCanvas(new GLCapabilities());
        //canvas.addGLEventListener(listener);
        //getContentPane().add(canvas);
    } 
    
    public static void main (String args[]){
        Practica1 frame = new Practica1();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);  
        
    }
  
    public void paint (Graphics g)
    {
        super.paint(g);
        Toolkit t = Toolkit.getDefaultToolkit ();
       Image imagen = t.getImage ("im.jpg");
        //Image imagen = t.getImage ("ImGOrigi.bmp");
       // g.drawImage (imagen, 100, 50, this);
        g.drawImage (imagen, 100, 100,300,300, this);
       try {
               //  BufferedImage img =ImageIO.read(new File("ima.jpg"));
              
                BufferedImage img =ImageIO.read(new File("ImGOrigi.bmp"));
                //gl.glVertex3f( 100, 50,100);
                
                
                for(int i=0; i<img.getWidth();i++){
                    for(int j=0; j<img.getHeight();j++){
                    int rgb =img.getRGB(i, j);
                    Color color =new Color (rgb,true);
                    int r=color.getRed();
                    int w = color.getGreen();
                }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }
    

    
     public class GraphicListener implements GLEventListener{

        public void display(GLAutoDrawable arg0) {
           // Indicamos el tamaño en pixeles del grosor de la linea
           gl.glLineWidth(5);
           //Indicamos que vamos a iniciar a crear lineas
          // gl.glDrawPixels(WIDTH, HEIGHT, NORMAL, WIDTH, HIDE_ON_CLOSE);
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
          gl.glColor3f(0,1,1);//funcion para los colores del punto
          gl.glPointSize(30);
           
                  //gl.glColor3f(1,1,1);
                 gl.glVertex2d(2,5);
                 // gl.glVertex2d(300,400);
                   
                  
            //Deshabilitamos la creacion de lineas (de la maquina de estados )
           gl.glEnd();

           gl.glFlush();

        }

        public void init(GLAutoDrawable arg0) {
            glu = new GLU();
            gl = arg0.getGL();
            gl.glClearColor(0, 0, 0, 0);
           
 
            //Establecer los parametros para la proyeccion
           // gl.glMatrixMode(gl.GL_PROJECTION);
            //glu.gluOrtho2D(-700, 700, -700, 700);
        }


        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        }

        public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

        }

    }

}