package Window;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Scene.BirdAndWoman;
import Scene.DogAndWoman;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements KeyListener , Runnable {

	JPanel scene ;
	JPanel scene1 ;
	JPanel scene2 ;
	JLabel founded ;

	DogAndWoman dog = new DogAndWoman() ;
	BirdAndWoman bird = new BirdAndWoman() ;
	boolean flag ;
	int wrongNum ;
	static int MAXWRONG = 4 ;
	public MainWindow() {
		scene1 = dog ;
		scene2 = bird ;
		scene = scene1 ;
		founded = new JLabel("已经发现的错误数： "+wrongNum+" / 4 ") ;	
		this.setSize( 500 , 400 ) ;
		this.setTitle( "大家来找茬" ) ;
		this.setLayout( null );
		scene.setBounds( 0 , 0 , 500 , 320 ) ;
		founded.setBounds( 150 , 330 , 200 , 20 );
		this.add(scene) ;
		this.add(founded) ;
		this.setLocationRelativeTo( null ) ;
		this.addKeyListener( this ) ;
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
		this.setVisible( true ) ;
		
		new Thread ( this ).start() ;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while ( true ) {
			try {
				Thread.sleep( 250 );
				if( scene == dog) {
					wrongNum = dog.getWrongFounded() ; 
				}else if (scene == bird ) {
					wrongNum = bird.getWrongFounded() ;
				}
				this.remove( founded );
				founded = new JLabel("已经发现的错误数： "+wrongNum+" / 4 ") ;	
				if ( wrongNum == MAXWRONG ) {
					wrongNum = 0 ;
					this.remove( scene ) ;
					flag = !flag ;
					if( flag ){
						scene = scene1 ;
					}else {
						scene = scene2 ;
					}
					scene.setBounds( 0 , 0 , 500 , 320 ) ;
					
					this.add(scene) ;
				}
				founded.setBounds( 150 , 330 , 200 , 20 );
				this.add( founded ) ;
				this.repaint() ;
				this.validate() ;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @Description: 键盘单击操作
	 * @param @param e   
	 * @throws
	 * @author Gavin
	 * @date 2015年3月8日
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
