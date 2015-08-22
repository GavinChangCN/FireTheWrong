package Scene;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BirdAndWoman extends JPanel implements MouseListener{

	BufferedImage leftImage ;
	BufferedImage rightImage ;
	int[][] imageData = new int[10][4] ;
	int wrongFounded ;
	public int getWrongFounded() {
		return wrongFounded;
	}

	public void setWrongFounded(int wrongFounded) {
		this.wrongFounded = wrongFounded;
	}

	public int[][] getImageData() {
		return imageData;
	}

	public void setImageData(int[][] imageData) {
		this.imageData = imageData;
	}

	public BirdAndWoman() {
		try {
			this.addMouseListener( this );
			leftImage = ImageIO.read( new File( "images/scene2/left.png" ) ) ;
			rightImage = ImageIO.read( new File( "images/scene2/right.png" ) ) ;
			for ( int x = 0; x < leftImage.getWidth() ; x++ ) {
				for ( int y = 0; y < leftImage.getHeight() ; y++ ) {
					int color1 = leftImage.getRGB( x , y ) ;
					int color2 = rightImage.getRGB( x , y ) ;
					if ( color1 != color2 ) {
						imageData[ x/50 ][ y/80 ] = 1 ;
					}
				}
			}
			for ( int x = 0; x < 5 ; x++ ) {
				for ( int y = 0; y < 4 ; y++ ) {
					imageData[x+5][y] = imageData[x][y] ;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace() ;
		}
	}
	
	public void paint( Graphics g ) {
		BufferedImage buffer = new BufferedImage( 500 , 320 , 3) ;
		Graphics mygGraphics = buffer.getGraphics() ;
		
		mygGraphics.drawImage( leftImage , 0 , 0 , null ) ;
		mygGraphics.drawImage( rightImage , 250 , 0 , null ) ;
		
		g.drawImage( buffer , 0 , 0 , null) ;
	}
	
	/**
	 * @Description: 单击鼠标事件
	 * @param @param e   
	 * @throws
	 * @author Gavin
	 * @date 2015年3月8日
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX() ;
		int y = e.getY() ;
		System.out.println( "鼠标点击的坐标：" ) ;
		System.out.println( "X:"+x+"    Y:"+y ) ;
		if( imageData[x/50][y/80] == 1) {
			wrongFounded ++ ;
			imageData[x/50][y/80] = 0 ;
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
